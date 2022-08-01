package memberChangeInfo;

import org.springframework.transaction.annotation.Transactional;

import member.Member;
import member.MemberDao;
import member.MemberNotFoundExcepttion;

public class ChangeInfoService {
	
	private MemberDao memberDao;
	
	public ChangeInfoService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void ChangeMemberInfo(String id, String name, String nickname) throws MemberNotFoundExcepttion {
		Member member = memberDao.selectByID(id);
		if(member==null)
			throw new MemberNotFoundExcepttion();
		member.setName(name);
		member.setNickname(nickname);
		
		memberDao.update(member);
	}
	
}
