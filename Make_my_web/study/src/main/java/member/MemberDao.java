package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private String selectByID_sql = "select * from MEMBER2 where ID = ?";
	private String insert_sql = "insert into MEMBER2 (ID, PASSWORD, NAME, NICKNAME) VALUES (?, ?, ?, ?)";
	private String update_sql = "update MEMBER set PASSWORD = ? where ID = ?";
	private String selectAll_sql = "";
	
	public MemberDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public Member selectByID(String ID) {
		List<Member> results = jdbcTemplate.query(selectByID_sql,
				new RowMapper<Member>() {
			
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				// ResultSet에 값을 받아온다 rowNum만큼
				Member member = new Member(
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getDate("REGDATE"),
						rs.getString("NICKNAME"));
				member.setId(rs.getString("ID"));
				
				return member;
			}
		}, ID);
		
		return results.isEmpty() ? null:results.get(0);
	}
	
	public void insert(final Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pstmt = con.prepareStatement(insert_sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getNickname());
				return pstmt;
			}
		});
	}
	
	public void update(Member member) {
		jdbcTemplate.update(update_sql,
				member.getPassword(), member.getName());
	}
	
	public Collection<Member> selectAll(){
		return null;
	}
}
