package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.WrongIdPasswordException;
import memberLogin.AuthInfo;
import memberLogin.AuthService;
import memberLogin.LoginRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginRequest loginRequest) {
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginRequest loginRequest, HttpSession session) {
		
		
		try {
			AuthInfo authInfo;
			authInfo = authService.authenticate(loginRequest.getId(), loginRequest.getPassword());
			session.setAttribute("authInfo", authInfo);
			
			return "login/loginSuccess";
		} catch (WrongIdPasswordException e) {
			return "login/loginForm";
		}
		
		
	}
	
}
