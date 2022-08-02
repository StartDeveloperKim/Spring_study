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
import notice.NoticeUpdateService;

@Controller
public class NoticeController {

	private NoticeLookupService noticeLookupService;
	private NoticeRegisterService noticeRegisterService;
	private NoticeUpdateService noticeUpdateService;

	public void setNoticeLookupService(NoticeLookupService noticeLookupService) {
		this.noticeLookupService = noticeLookupService;
	}

	public void setNoticeRegisterService(NoticeRegisterService noticeRegisterService) {
		this.noticeRegisterService = noticeRegisterService;
	}

	public void setNoticeUpdateService(NoticeUpdateService noticeUpdateService) {
		this.noticeUpdateService = noticeUpdateService;
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
	public String handledetail(@RequestParam(value = "id", required = false) int noticeId, Model model)
			throws NoticeNotFoundException {
		Notice notice = noticeLookupService.detaillookup(noticeId);
		if (notice == null) {
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
	public String handleinsertend(@ModelAttribute("insertRequest") NoticeInsertRequest insertRequest,
			HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		noticeRegisterService.regist(insertRequest, authInfo.getNickname());

		return "notice/insertend";
	}

	/*----------------------게시판 글 수정------------------------------*/

	@GetMapping("/notice/update")
	public String handleupdate(@RequestParam(value="id") int id,Model model) {
		Notice notice = noticeLookupService.detaillookup(id);
		model.addAttribute("insertRequest", new NoticeInsertRequest());
		model.addAttribute("id", id);
		model.addAttribute("notice", notice);
		return "notice/update";
	}

	@PostMapping("/notice/updateend")
	public String handleupdateend(@ModelAttribute("insertRequest") NoticeInsertRequest insertRequest,
			@RequestParam(value = "id") int id) throws NoticeNotFoundException {
		noticeUpdateService.update(insertRequest, id);

		return "notice/updateend";
	}
}
