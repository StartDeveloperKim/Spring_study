package notice;

public class NoticeUpdateService {
	
	private NoticeDao noticeDao;

	public NoticeUpdateService(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	public void update(NoticeInsertRequest insertRequest, int id) throws NoticeNotFoundException {
		Notice notice = noticeDao.SelectById(id);
		if(notice==null) {
			throw new NoticeNotFoundException();
		}
		
		notice.setTitle(insertRequest.getTitle());
		notice.setContent(insertRequest.getContent());
		notice.setId(id);
		
		noticeDao.update(notice);
	}
}
