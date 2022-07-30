package chapter2.spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() {
	}
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req) throws DuplicateMemberException {
		Member member = memberDao.selectByEmail(req.getEmail());
		// 이메일을 통해 Map 구조에서 해당 이메일에 맞는 멤버를 가져온다.
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}// null이 아니라는 것은 이미 해당되는 이메일의 멤버가 존재한다는 것
		
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				LocalDateTime.now());
		// 새 멤버에 대한 객체를 생성
		
		memberDao.insert(newMember); // 새 멤버를 등록
		
		return newMember.getId();
	}
}
