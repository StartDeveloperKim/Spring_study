package notice;

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

public class NoticeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private String selectAll_sql = "select * from NOTICE";
	private String selectById_sql = "select * from NOTICE WHERE ID = ?";
	private String insert_sql = "insert into NOTICE (TITLE, CONTENT, WRITER_ID) values (?, ?, ?)";
	
	public NoticeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Notice> noticeRowMapper = new RowMapper<Notice>() {
		@Override
		public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
			Notice notice = new Notice(
					rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getString("WRITER_ID"));
			notice.setId(rs.getInt("ID"));
			notice.setRegdate(rs.getDate("REGDATE"));
			notice.setHit(rs.getInt("HIT"));
			
			return notice;
		}
		
	};
	
	public Notice SelectById(int id) {
		List<Notice> results = jdbcTemplate.query(selectById_sql, noticeRowMapper, id);
		
		return results.isEmpty() ? null : results.get(0);
	}

	public Collection<Notice> SelectAll(){
		List<Notice> results = jdbcTemplate.query(selectAll_sql, noticeRowMapper);
		
		return results;
	}
	
	public void insert(final Notice notice) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pstmt = con.prepareStatement(insert_sql);
				
				pstmt.setString(1, notice.getTitle());
				pstmt.setString(2, notice.getContent());
				pstmt.setString(3, notice.getWriter_id());
				return pstmt;
			}
		});
	}
}
