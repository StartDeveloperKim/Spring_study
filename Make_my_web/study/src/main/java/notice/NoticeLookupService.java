package notice;

import java.util.List;

public class NoticeLookupService {
	
	private NoticeDao noticeDao;

	public NoticeLookupService(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	public List<Notice> listlookup() {
		List<Notice> notices = (List<Notice>) noticeDao.SelectAll();
		
		return notices;
	}
	
	public Notice detaillookup(int id) {
		Notice notice = noticeDao.SelectById(id);
		
		return notice;
	}
}
