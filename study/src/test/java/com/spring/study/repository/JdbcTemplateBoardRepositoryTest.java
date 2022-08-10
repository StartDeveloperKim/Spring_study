package com.spring.study.repository;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.util.List;

@SpringBootTest
@Transactional
class JdbcTemplateBoardRepositoryTest {
    @Autowired
    private final DataSource dataSource;

    JdbcTemplateBoardRepositoryTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    BoardRepository boardRepository;

    @BeforeEach
    public void beforeEach(){
        boardRepository = new JdbcTemplateBoardRepository(dataSource);
    }


    @Test
    @DisplayName("페이징 테스트입니다.")
    public void Paging_test(){
        Critertia critertia = new Critertia();
        critertia.setPageNum(1);
        critertia.setAmount(10);

        List<BoardVO> result = boardRepository.getListWithPaging(critertia);
        Assertions.assertThat(result.size()).isEqualTo(10);
    }
}