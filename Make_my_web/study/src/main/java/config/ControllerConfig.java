package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.ChangePasswordService;
import member.MemberController;
import member.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Bean
	public MemberController memberController() {
		MemberController controller = new MemberController();
		controller.setMemberRegisterService(memberRegSvc);
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
}
