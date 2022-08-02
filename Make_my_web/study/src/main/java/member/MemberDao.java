/*현재 완료된 기능*/
/*ID별 멤버 조회
 *  멤버 등록 
 *  비밀번호 업데이트 */

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
	private String update_sql = "update MEMBER2 set PASSWORD = ?, NAME = ?, NICKNAME = ? where ID = ?";
	private String selectAll_sql = "select * from MEMBER2";
	
	public MemberDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	} // 생성자를 통해 의존주입
	
	/*중복되는 코드 정리*/
	private RowMapper<Member> memRowMapper = new RowMapper<Member>() {
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
	};
	
	// 한개 출력하기 : jdbcTemplate.queryForObject(sql문, RowMapper, 가변인자)
	// 여러개 출력하기 : jdbcTemplate.query(인자1, 인자2, 인자3)
	// SELECT문은 RowMapper -> mapRow를 이용한다.
	public Member selectByID(String ID) {
		List<Member> results = jdbcTemplate.query(selectByID_sql, memRowMapper, ID);
		
		return results.isEmpty() ? null:results.get(0);
	}
	
	//INSERT, UPDATE, DELETE 작업은 update문을 이용한다.
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
				member.getPassword(), member.getName(), member.getNickname(), member.getId());
	}
	
	// 모든 멤버 조회
	public Collection<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(selectAll_sql, memRowMapper);
		
		return results;
	}
}
