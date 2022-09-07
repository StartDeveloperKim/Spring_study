package study.ajax.sample1.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.ajax.sample1.board.domain.Board;
import study.ajax.sample1.board.repository.MemoryBoardRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final MemoryBoardRepository boardRepository;

    public Board register(Board board) {
        return boardRepository.insert(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}