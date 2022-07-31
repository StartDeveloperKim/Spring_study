/*DB - MEMBER Table DAO*/

package member;

import java.util.Date;

public class Member {

	private String id;
	private String password;
	private String name;
	private Date regdate;
	private String nickname;

	public Member(String password, String name, Date regdate, String nickname) {
		this.password = password;
		this.name = name;
		this.regdate = regdate;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void changePassword(String oldPassword, String newPassword) throws WrongIdPasswordException {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}
