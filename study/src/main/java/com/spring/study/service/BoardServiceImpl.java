package com.spring.study.service;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import com.spring.study.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override // 회원 등록하기
    public void register(BoardVO board) {
        boardRepository.insert(board);
    }

    @Override // bno로 게시물 한개 가져오기
    public BoardVO get(Long bno) {
        return boardRepository.read(bno);
    }

    @Override // 게시물 수정하기
    public boolean modify(BoardVO board) {
        return boardRepository.update(board) == 1;
    }

    @Override // 게시물 삭제하기
    public boolean remove(Long bno) {
        return boardRepository.delete(bno) == 1;
    }

    @Override // 게시물 페이지별로 가져오기
    public List<BoardVO> getList(Critertia cri) {
        return boardRepository.getListWithPaging(cri);
    }

    @Override // 전체 게시물 개수 구하기
    public int getTotal(Critertia cri) {
        return boardRepository.getTotalCount(cri);
    }

    @Override // 6개의 게시물만 가져오기 --> 최신순으로 가져오기 --> 추천수로 가져오기(이거는 다음에 구현하자)
    public List<BoardVO> getFewList() {
        return boardRepository.getFewList();
    }

   /* @Override
    public List<BoardVO> getList() {
        return boardRepository.getList();
    }*/
}
