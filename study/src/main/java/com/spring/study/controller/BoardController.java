package com.spring.study.controller;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import com.spring.study.domain.PageDTO;
import com.spring.study.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor // 생성자 대신 내부 프로퍼티에 자동 의존주입
@RequestMapping("/board/*")
/*@AllArgsConstructor*/ // 이 어노테이션을 이용하면 필드 내 변수에 대해 생성자를 통해 자동으로 의존주입을 실행한다.
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(
            @RequestParam(required = false, name = "pageNum") String pageNum,
            @RequestParam(required = false, name = "amount") String amount,
            Critertia critertia, Model model){
        model.addAttribute("list", boardService.getList(critertia));
        int total = boardService.getTotal(critertia);

        //System.out.println(critertia.toString());
        model.addAttribute("pageMaker", new PageDTO(critertia, total));
    }

    @GetMapping("/register")
    public void register(){
        // 반환타입을 void로 지정하면 Mapping된 view로 이동한다.
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr) {
        boardService.register(boardVO);
        /*rttr.addFlashAttribute("result", boardVO.getBno());*/
        rttr.addFlashAttribute("result", 0);
        // bno는 DB쪽에서 시퀀스를 통해 증가시킴으로 서버쪽에서 insert를 할 때는 알 수가 없다.

        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Critertia cri
            ,Model model) {
        //System.out.println(bno);
        model.addAttribute("board", boardService.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO boardVO, @ModelAttribute("cri") Critertia cri, RedirectAttributes rttr) {

        if (boardService.modify(boardVO)) {
            rttr.addFlashAttribute("result", "success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno,
            @ModelAttribute("cri") Critertia cri, RedirectAttributes rttr){
        //System.out.println(bno);
        if(boardService.remove(bno)){
            rttr.addFlashAttribute("result", "success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        return "redirect:/board/list";
    }
}
