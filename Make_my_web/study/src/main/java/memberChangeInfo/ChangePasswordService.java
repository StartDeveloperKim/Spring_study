/*비밀번호 변경 서비스*/
/*1. 닉네임 변경 추가하기
 *2. 아이디 변경 추가하기*/

package memberChangeInfo;

import member.Member;
import member.MemberDao;
import member.MemberNotFoundExcepttion;
import member.NotEqualConfirmPwd;
import member.WrongIdPasswordException;

public class ChangePasswordService {
	
	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	} // 생성자를 통해 memberDao 의존주입 스프링은 싱글톤이라 하나의 종류의 객체가 생성
	
	public void changePassword(String id, String oldPwd, String newPwd, String confirmPwd) throws WrongIdPasswordException, MemberNotFoundExcepttion, NotEqualConfirmPwd {
		Member member = memberDao.selectByID(id);
		if(member==null)
			throw new MemberNotFoundExcepttion();
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member); // update 진행
	}
	
	
}
