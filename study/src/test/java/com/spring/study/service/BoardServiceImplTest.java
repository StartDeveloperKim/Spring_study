package com.spring.study.service;

import com.spring.study.domain.BoardVO;
import com.spring.study.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class BoardServiceImplTest {
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    void register() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("김태우입니다.");
        boardVO.setContent("JDBC 실험입니다.");
        boardVO.setWriter("킹태우");

        boardService.register(boardVO);
    }

    @Test
    void get() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(3L);

        boardService.get(boardVO.getBno());
    }

    @Test
    void modify(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("김태우입니다.");
        boardVO.setContent("JDBC 실험입니다.");
        boardVO.setWriter("킹태우");

        boardService.modify(boardVO);
    }

    @Test
    void remove() {
        boardService.remove(3L);
    }

    @Test
    void getList() {
        boardService.getList();
    }

}