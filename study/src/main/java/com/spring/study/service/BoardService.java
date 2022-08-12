package com.spring.study.service;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board); // 회원등록

    public BoardVO get(Long bno); // 게시물 한개 가져오기

    public boolean modify(BoardVO board); // 게시물 수정하기

    public boolean remove(Long bno); // 게시물 삭제하기

    //public List<BoardVO> getList();

    public List<BoardVO> getList(Critertia cri); // page별로 잘라서 들고오기

    public int getTotal(Critertia cri); // 게시물 전체 개수 구해오기

    public List<BoardVO> getFewList(); // Welcome Page에 나올 게시물 6개만 가져오기

}
