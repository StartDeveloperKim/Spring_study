/*비밀번호 변경 서비스*/
/*1. 닉네임 변경 추가하기
 *2. 아이디 변경 추가하기*/

package member;

public class ChangePasswordService {
	
	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	} // 생성자를 통해 memberDao 의존주입 스프링은 싱글톤이라 하나의 종류의 객체가 생성
	
	public void changePassword(ChangeRequest req) throws NotExistMember, WrongIdPasswordException {
		Member member = memberDao.selectByID(req.getId()); // ChangeRequest DTO에서 아이디를 get해서 그에 맞는 멤버를 찾아옴
		if(member==null) {
			throw new NotExistMember("존재하지 않는 아이디 입니다.");
		} // 없으면 예외 throw
		
		member.changePassword(req.getOldPwd(), req.getNewPwd());
		// 해당 멤버에 대한 비밀번호 변경
		
		memberDao.update(member); // update 진행
		
	}
	
}
