package com.spring.study.controller;

import com.spring.study.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    private BoardService boardService;

    @Autowired
    public WelcomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("boardList", boardService.getFewList());
        return "welcome";
    }
}
