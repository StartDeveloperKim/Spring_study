/*비밀변호 변경 요청 DTO(Data Transfer Object)*/

package memberChangeInfo;

public class ChangeRequest {
	
	private String oldPwd;
	private String newPwd;
	private String confirmapassword;
	
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
	
	public String getConfirmapassword() {
		return confirmapassword;
	}
	
	public void setConfirmapassword(String confirmapassword) {
		this.confirmapassword = confirmapassword;
	}
	

}
