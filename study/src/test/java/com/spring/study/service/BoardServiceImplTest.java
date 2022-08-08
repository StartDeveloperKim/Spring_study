package com.spring.study.service;

import com.spring.study.domain.BoardVO;
import com.spring.study.repository.BoardRepository;
import com.spring.study.repository.JdbcTemplateBoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
    }
}