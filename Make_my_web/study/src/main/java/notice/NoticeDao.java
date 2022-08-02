package notice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class NoticeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private String selectAll_sql = "select * from NOTICE";
	private String selectById_sql = "select * from NOTICE WHERE ID = ?";
	
	public NoticeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Notice> noticeRowMapper = new RowMapper<Notice>() {
		@Override
		public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
			Notice notice = new Notice(
					rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getDate("REGDATE"),
					rs.getString("WRITER_ID"),
					rs.getInt("HIT"));
			notice.setId(rs.getInt("ID"));
			
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
}
