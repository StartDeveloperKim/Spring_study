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

    @Override
    public void register(BoardVO board) {
        boardRepository.insert(board);
    }

    @Override
    public BoardVO get(Long bno) {
        return boardRepository.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        return boardRepository.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        return boardRepository.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Critertia cri) {
        return boardRepository.getListWithPaging(cri);
    }

    @Override
    public List<BoardVO> getList() {
        return boardRepository.getList();
    }
}
