package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.MemberController;
import member.AuthService;
import member.ChangePasswordService;
import member.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private AuthService authService;
	
	@Bean
	public MemberController memberController() {
		MemberController controller = new MemberController();
		controller.setMemberRegisterService(memberRegSvc);
		controller.setChangePasswordService(changePasswordService);
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
