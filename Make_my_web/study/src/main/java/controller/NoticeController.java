package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import memberLogin.AuthInfo;
import notice.Notice;
import notice.NoticeInsertRequest;
import notice.NoticeLookupService;
import notice.NoticeNotFoundException;
import notice.NoticeRegisterService;

@Controller
public class NoticeController {
	
	private NoticeLookupService noticeLookupService;
	private NoticeRegisterService noticeRegisterService;
	
	public void setNoticeLookupService(NoticeLookupService noticeLookupService) {
		this.noticeLookupService = noticeLookupService;
	}
	public void setNoticeRegisterService(NoticeRegisterService noticeRegisterService) {
		this.noticeRegisterService = noticeRegisterService;
	}
	
	/*----------------------게시판 리스트 조회------------------------------*/
	
	@GetMapping("/notice/list")
	public String handlelist(Model model) {
		List<Notice> notices = noticeLookupService.listlookup(); 
		model.addAttribute("notices", notices);
		
		return "notice/list";
	}
	
	/*----------------------게시판 디테일 조회------------------------------*/
	
	@GetMapping("/notice/detail")
	public String handledetail(@RequestParam(value="id", required = false)
	int noticeId, Model model) throws NoticeNotFoundException {
		Notice notice = noticeLookupService.detaillookup(noticeId);
		if(notice == null) {
			throw new NoticeNotFoundException();
		}
		model.addAttribute("notice", notice);
		
		return "notice/detail";
	}
	
	/*----------------------게시판 글 등록------------------------------*/
	
	@GetMapping("/notice/insert")
	public String handleinsert(Model model) {
		model.addAttribute("insertRequest", new NoticeInsertRequest());
		return "notice/insert";
	}
	
	@PostMapping("/notice/insertend")
	public String handleinsertend(@ModelAttribute("insertRequest") NoticeInsertRequest insertRequest, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		noticeRegisterService.regist(insertRequest, authInfo.getNickname());
		
		return "notice/insertend";
	}
}
