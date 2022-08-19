package com.spring.study.repository;


import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import com.spring.study.domain.UpdateDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardRepository {

    public List<BoardVO> getList();

    public List<BoardVO> getListWithPaging(Critertia cri); // 페이지별 리스트 가져오기

    public void insert(BoardVO board); // DB에 입력하기

    public void insertSelectKey(BoardVO board); //

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);
    //public int update(UpdateDTO updateDTO);

    public int getTotalCount(Critertia cri);

    public List<BoardVO> getFewList();
}
