package memberLogin;

public class AuthInfo {
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	
	public AuthInfo(String id, String password, String name, String nickname) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}
	
	
	
}
