package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.MemberController;
import controller.NoticeController;
import member.MemberLookupService;
import memberChangeInfo.ChangeInfoService;
import memberChangeInfo.ChangePasswordService;
import memberLogin.AuthService;
import memberRegister.MemberRegisterService;
import notice.NoticeLookupService;
import notice.NoticeRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ChangeInfoService changeInfoService;
	
	@Autowired
	private MemberLookupService memberLookupService;
	
	@Autowired
	private NoticeLookupService noticeLookupService;
	
	@Autowired
	private NoticeRegisterService noticeRegisterService;
	
	@Bean
	public MemberController memberController() {
		MemberController controller = new MemberController();
		controller.setMemberRegisterService(memberRegSvc);
		controller.setChangePasswordService(changePasswordService);
		controller.setChangeInfoService(changeInfoService);
		controller.setMemberLookupService(memberLookupService);
		return controller;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public NoticeController noticeController() {
		NoticeController controller = new NoticeController();
		controller.setNoticeLookupService(noticeLookupService);
		controller.setNoticeRegisterService(noticeRegisterService);
		return controller;
	}
}
