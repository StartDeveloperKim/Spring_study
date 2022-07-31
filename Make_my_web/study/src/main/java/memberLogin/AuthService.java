package memberLogin;

import member.Member;
import member.MemberDao;
import member.WrongIdPasswordException;

public class AuthService {
	
	private MemberDao memberDao;
	
	public AuthService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String id, String password) throws WrongIdPasswordException {
		Member member = memberDao.selectByID(id);
		if(member==null) {
			throw new WrongIdPasswordException();
		}
		if(!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		
		return new AuthInfo(member.getId(), member.getPassword(), member.getName(), member.getNickname());
	}
}
