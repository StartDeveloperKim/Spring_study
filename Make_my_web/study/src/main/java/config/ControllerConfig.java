package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.MemberController;
import member.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Bean
	public MemberController memberController() {
		MemberController controller = new MemberController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
}
