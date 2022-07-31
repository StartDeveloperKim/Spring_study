package member;

public class AuthInfo {
	
	private String id;
	private String nickname;
	
	public AuthInfo(String id, String nickname) {
		this.id = id;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}
	
	public String getNickname() {
		return nickname;
	}
	
}
