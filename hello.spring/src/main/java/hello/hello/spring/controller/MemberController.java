package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/register")
    public String register_(){
        return "/register";
    }
}
