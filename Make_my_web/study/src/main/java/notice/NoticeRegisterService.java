package notice;

import org.springframework.transaction.annotation.Transactional;

public class NoticeRegisterService {
	
	private NoticeDao noticeDao;
	
	public NoticeRegisterService(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Transactional
	public void regist(NoticeInsertRequest insertRequest, String nickname) {
		
		Notice newNotice = new Notice(insertRequest.getTitle(),
				insertRequest.getContent(),
				nickname);
		noticeDao.insert(newNotice);
	}
	
}
