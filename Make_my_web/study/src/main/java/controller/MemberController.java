package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.DuplicateMemberException;
import member.Member;
import member.MemberLookupService;
import member.MemberNotFoundExcepttion;
import member.NotEqualConfirmPwd;
import member.WrongIdPasswordException;
import memberChangeInfo.ChangeInfoService;
import memberChangeInfo.ChangePasswordService;
import memberChangeInfo.ChangeRequest;
import memberChangeInfo.ChangeRequestInfo;
import memberLogin.AuthInfo;
import memberRegister.MemberRegisterService;
import memberRegister.RegisterRequest;
import validator.RegisterRequestValidator;

@Controller
public class MemberController {
	
	// 멤버등록, 비밀번호 변경 클래스 변수
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	private ChangeInfoService changeInfoService;
	private MemberLookupService memberLookupService;
	
	// 두 멤버 변수 모두 setter 함수를 통해 의존 주입
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	public void setChangeInfoService(ChangeInfoService changeInfoService) {
		this.changeInfoService = changeInfoService;
	}
	
	public void setMemberLookupService(MemberLookupService memberLookupService) {
		this.memberLookupService = memberLookupService;
	}
	
	/*----------------------회원 등록------------------------------*/
	
	@RequestMapping("/register/step1") // RequestMapping은 클래스단에서 쓰는 것이 좋다. 메서드는 GetMapping 또는 PostMapping
	public String handleStep1() {
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		if(!agree) {
			return "register/step1";
		} // 나중에 동의가 되어있지않으면 메시지를 띄우거나 빨간 글씰를 적을 수 있도록 하자
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		// 해당 url로 바로 접근시도하면 아래의 링크로 redirect
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors())
			return "register/step2";
		
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException e) {
			errors.rejectValue("id", "duplicate.id");
			return "register/step2";
			/*추가해야할 기능*/
			// 중복된 아이디를 step2.jsp에서 확일할 수 있게 바꾸기
		}
		
	}
	
	/*-------------------------------------------------------------------------------*/
	
	
	/*----------------------비밀번호 변경------------------------------------------------*/
	
	// 비밀번호 또는 닉네임 변경 요청시 만들어지는 실행된다.
	@GetMapping("/register/changePwd")
	public String handleChangePwd(ChangeRequest chaReq) {
		return "register/changePwd";
	}
	
	@PostMapping("/register/changeend")
	public String handleChangeEnd(ChangeRequest chaReq, HttpSession session) throws MemberNotFoundExcepttion, NotEqualConfirmPwd {
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			
			changePasswordService.changePassword(authInfo.getId(), chaReq.getOldPwd(), chaReq.getNewPwd(), chaReq.getConfirmapassword());
			return "register/changeend";
		} catch (WrongIdPasswordException e) {
			// 틀린 ID와 Password 일때 --> 오류 메시지로 바꿀 것
			return "/register/changePwd";
		}
		
	}
	
	/*-----------------------------회원 정보 변경-----------------------------------------*/
	
	@GetMapping("register/changeinfo")
	public String handleChangeInfo(ChangeRequestInfo chaReqInfo) {
		return "register/changeinfo";
	}
	
	@PostMapping("register/changeinfoend")
	public String handleChangeInfoEnd(ChangeRequestInfo chaReqInfo, HttpSession session) {
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			changeInfoService.ChangeMemberInfo(authInfo.getId(), chaReqInfo.getName(), chaReqInfo.getNickname());
			return "register/changeend";
		} catch (MemberNotFoundExcepttion e) {
			return "/register/changeinfo";
		}
	}
	/*-----------------------------회원 목록 조회--------------------------------------*/
	
	@GetMapping("/lookup")
	public String handleLookupMember(Model model) {
		List<Member> members = memberLookupService.lookupService();
		
		model.addAttribute("members", members);
		
		return "lookup/members";
	}
}
