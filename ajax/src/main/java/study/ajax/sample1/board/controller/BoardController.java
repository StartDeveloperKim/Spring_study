package study.ajax.sample1.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import study.ajax.sample1.board.domain.Board;
import study.ajax.sample1.board.service.BoardService;
import study.ajax.sample1.reply.domain.ReplyRegisterVO;

import javax.annotation.PostConstruct;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "/board/list";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        model.addAttribute("reply", new ReplyRegisterVO());

        return "/board/detail";
    }

    /*테스트용 데이터 추가*/
    @PostConstruct
    public void init() {
        boardService.register(new Board("비동기처리 공부", "하하하하", "킹킹"));
        boardService.register(new Board("성공하자 제발", "나는 할 수 있다.", "콩콩"));
    }
}
