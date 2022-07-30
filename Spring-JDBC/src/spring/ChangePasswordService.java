package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	
	private MemberDao memberDao;
	
	@Transactional // 트랜잭션 처리를 위한 설정
	public void changePassword(String email, String oldPwd, String newPwd) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);
		// 해당 email에 맞는 member가 있는지 확인
		if(member == null) // 없으면 exception
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		// 해당 멤버에 대한 password 변경
		
		memberDao.update(member); // 업데이트
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao; // 의존주입
	}
}
