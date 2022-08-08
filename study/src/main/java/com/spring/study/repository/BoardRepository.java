package com.spring.study.repository;


import com.spring.study.domain.BoardVO;

import java.util.List;

public interface BoardRepository {
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);

}
