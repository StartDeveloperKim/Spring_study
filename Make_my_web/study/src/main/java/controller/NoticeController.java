package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import notice.Notice;
import notice.NoticeLookupService;
import notice.NoticeNotFoundException;

@Controller
public class NoticeController {
	
	private NoticeLookupService noticeLookupService;
	
	public void setNoticeLookupService(NoticeLookupService noticeLookupService) {
		this.noticeLookupService = noticeLookupService;
	}
	
	@GetMapping("/notice/list")
	public String handlelist(Model model) {
		List<Notice> notices = noticeLookupService.listlookup(); 
		model.addAttribute("notices", notices);
		
		return "notice/list";
	}
	
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
	
	
}
