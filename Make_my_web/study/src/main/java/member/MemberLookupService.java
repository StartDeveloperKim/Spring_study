package member;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class MemberLookupService {
	
	private MemberDao memberDao;

	public MemberLookupService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Transactional
	public List<Member> lookupService(){
		
		List<Member> members = (List<Member>) memberDao.selectAll();
		
		return members;
	}
}
