package com.spring.study.service;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

    //public List<BoardVO> getList();

    public List<BoardVO> getList(Critertia cri);

    List<BoardVO> getList();
}
