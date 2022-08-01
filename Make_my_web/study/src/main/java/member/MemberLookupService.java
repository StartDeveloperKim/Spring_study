package member;

import java.util.List;

public class MemberLookupService {
	
	private MemberDao memberDao;

	public MemberLookupService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public List<Member> lookupService(){
		
		List<Member> members = (List<Member>) memberDao.selectAll();
		
		return members;
	}
}
