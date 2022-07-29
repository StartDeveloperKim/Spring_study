/*멤버등록 서비스*/

package member;

import java.time.LocalDateTime;
import java.util.Date;

public class MemberRegisterService {
	
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public String regist(RegisterRequest req) throws DuplicateMemberException {
		Member member = memberDao.selectByID(req.getId());
		if(member != null) {
			throw new DuplicateMemberException("중복된 아이디 입니다." + req.getId());
		}
		
		//그냥 현재시간 받아오기
		LocalDateTime localDateTime = LocalDateTime.now();
		Date date = java.sql.Timestamp.valueOf(localDateTime);
		
		
		Member newMember = new Member(
				req.getPassword(), req.getName(), date, req.getNickname());
		newMember.setId(req.getId());
		
		memberDao.insert(newMember);
		return newMember.getId();
	}
	
}
