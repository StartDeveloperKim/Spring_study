package com.spring.study.service;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import com.spring.study.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class BoardServiceImplTest {
    @Autowired
    BoardService boardService;

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
        Critertia critertia = new Critertia();
        critertia.setPageNum(1);
        critertia.setAmount(10);
        List<BoardVO> result = boardService.getList(critertia);

        for(BoardVO i : result){
            System.out.println(i.toString());
        }
        Assertions.assertThat(result.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("총 6개의 데이터를 받아와야 한다.")
    void getFewListTest(){
        List<BoardVO> result = boardService.getFewList();

        for (BoardVO i : result) {
            System.out.println(i.toString());
        }
        Assertions.assertThat(result.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("getList 테스트")
    void getListTest(){
        List<BoardVO> list = boardRepository.getList();
        for (BoardVO boardVO : list) {
            System.out.println(boardVO.toString());
        }
    }

}