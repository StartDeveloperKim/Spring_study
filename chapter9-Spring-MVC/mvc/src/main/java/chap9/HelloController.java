package chap9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// Controller 어노테이션으로 스프링 MVC에서 컨트롤러로 사용한다.
public class HelloController {
	
	@GetMapping("/hello") // 메서드가 처리할 요청 결로를 지정
	public String hello(Model model,
			@RequestParam(value = "name", required = false) String name) {
		
		model.addAttribute("greeting", "안녕하세요, " + name);// map 형태로 저장
		return "hello";
	}
}
