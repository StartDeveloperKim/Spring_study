package com.spring.study.controller;

import com.spring.study.domain.RegisterDTO;
import com.spring.study.service.MemberRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    private final MemberRegisterService memberRegisterService;

    public MemberController(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }


    @GetMapping("/register")
    public String memberRegisterer() {
        return "/member/register";
    }

    @PostMapping("/register")
    public String memberRegister(RegisterDTO registerDTO) {
        memberRegisterService.register(registerDTO);

        return "redirect:/welcome";
    }
}
