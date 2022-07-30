/*비밀변호 변경 요청 DTO(Data Transfer Object)*/

package member;

public class ChangeRequest {
	
	private String id;
	private String oldPwd;
	private String newPwd;
	private String confirmPassword;
	//private String nickname;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOldPwd() {
		return oldPwd;
	}
	
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	
	public String getNewPwd() {
		return newPwd;
	}
	
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
