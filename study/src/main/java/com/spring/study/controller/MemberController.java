package com.spring.study.controller;

import com.spring.study.domain.RegisterDTO;
import com.spring.study.error.RegisterRequestValidator;
import com.spring.study.service.MemberRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRegisterService memberRegisterService;

    /*생성자가 한개라면 Autowired가 되지만 나는 아직 초보자이므로 명시적으로 적어두는 것!! --> 생성자 DI*/
    /*Lombok의 RequiredArgsConstructor 어노테이션은 final키워드가 붙은 프로퍼티에 자동 의존주입을 해준다.*/

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
