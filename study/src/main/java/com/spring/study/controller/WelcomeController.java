package com.spring.study.controller;

import com.spring.study.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final BoardService boardService;

    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("boardList", boardService.getFewList());
        return "welcome";
    }
}
