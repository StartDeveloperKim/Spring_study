package spring;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		} // null이 아니라는 것은 중복된 이메일이 있다는 것이다.
		

		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		// 새 멤버에 대한 객체 생성
		memberDao.insert(newMember); // insert 쿼리 실행
		return newMember.getId();
	}
}
