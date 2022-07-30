package spring;

import java.time.LocalDateTime;
import java.util.Date;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDateTime;
	
	
	
	public Member(String email, String password, String name, Date registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public Date getRegisterDateTime() {
		return registerDateTime;
	}
	
	public void setRegisterDateTime(Date registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword) throws WrongIdPasswordException {
		if(!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password= newPassword;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
}
