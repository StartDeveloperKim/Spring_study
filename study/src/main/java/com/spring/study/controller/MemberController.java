package com.spring.study.controller;

import com.spring.study.domain.RegisterDTO;
import com.spring.study.error.RegisterRequestValidator;
import com.spring.study.service.MemberRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String memberRegisterer(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "/member/register";
    }

    @PostMapping("/register")
    public String memberRegister(RegisterDTO registerDTO, Errors errors) {
        new RegisterRequestValidator().validate(registerDTO, errors);
        if (errors.hasErrors()){
            System.out.println(errors.toString());
            return "/member/register";
        }
        memberRegisterService.register(registerDTO);

        return "redirect:/welcome";
    }
}
