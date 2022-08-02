/*노티스 테이블 DAO*/

package notice;

import java.util.Date;

public class Notice {
	
	private int id;
	private String title;
	private String content;
	private Date regdate;
	private String writer_id;
	private int hit;
	
	public Notice(String title, String content, String writer_id) {
		this.title = title;
		this.content = content;
		this.writer_id = writer_id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String getWriter_id() {
		return writer_id;
	}
	
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	
	public int getHit() {
		return hit;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	

}
