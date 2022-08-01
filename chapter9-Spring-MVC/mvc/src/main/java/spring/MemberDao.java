package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	// 각 함수에 대한 쿼리 문
	private String selectByEmail_sql = "select * from MEMBER where EMAIL = ?";
	private String selectAll_sql = "select * from MEMBER";
	private String count_sql = "select count(*) from MEMBER";
	private String update_sql = "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?";
	private String insert_sql = "insert into MEMBER (EMAIL, PASSWORD, NAME) VALUES (?, ?, ?)";
	private String selectByid_sql = "select * from MEMBER where ID between ? and ? order by ID desc";
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(selectByEmail_sql,
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Member member = new Member(
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getDate("REGDATE"));
				member.setId(rs.getLong("ID"));
				
				return member;
			}
		}, email); // query()함수의 마지막 인자는 가변인자 설정이다.
		
		return results.isEmpty() ? null : results.get(0);
		// 결과가 비어있을 수도 있기에 비어있으면 null을 반환
	}
	
	public void insert(final Member member) {
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pstmt = con.prepareStatement(insert_sql);
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				return pstmt;
			}
		});
	}
	
	public void update(Member member) {
		jdbcTemplate.update(update_sql,
				member.getName(), member.getPassword(), member.getEmail());
	}
	
	public Collection<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(selectAll_sql, 
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getDate("REGDATE"));
				member.setId(rs.getLong("ID"));
				return member;
			}
		});
		
		return results;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				count_sql, Integer.class);
		return count;
	}
	
	public List<Member> selectByid(Long from, Long to){
		
		List<Member> results = jdbcTemplate.query(selectByid_sql,
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Member member = new Member(
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getDate("REGDATE"));
				member.setId(rs.getLong("ID"));
				return member;
			}
		}, from, to);
		
		return results;
	}
}
