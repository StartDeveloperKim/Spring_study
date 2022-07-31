package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.MemberController;
import memberChangeInfo.ChangeInfoService;
import memberChangeInfo.ChangePasswordService;
import memberLogin.AuthService;
import memberRegister.MemberRegisterService;

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
	
	@Bean
	public MemberController memberController() {
		MemberController controller = new MemberController();
		controller.setMemberRegisterService(memberRegSvc);
		controller.setChangePasswordService(changePasswordService);
		controller.setChangeInfoService(changeInfoService);
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
}
