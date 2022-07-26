package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	private String selectByEmail_sql = "select * from MEMBER where EMAIL = ?";
	private String selectAll_sql = "select * from MEMBER";
	private String count_sql = "select count(*) from MEMBER";
	private String update_sql = "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?";
	private String insert_sql = "insert into MEMBER (EMAIL, PASSWORD, NAME) VALUES (?, ?, ?)";
	
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
		}, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(Member member) {
		
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
}
