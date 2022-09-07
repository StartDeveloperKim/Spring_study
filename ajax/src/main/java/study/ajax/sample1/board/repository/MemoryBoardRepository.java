package study.ajax.sample1.board.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import study.ajax.sample1.board.domain.Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class MemoryBoardRepository {

    private static final Map<Long, Board> store = new HashMap<>();
    private static long seq = 0L;

    /**
     * 글 등록
     * @param board
     * @return
     */
    public Board insert(Board board) {
        board.setId(++seq);
        store.put(board.getId(), board);
        return board;
    }

    /**
     * 글 아이디로 글 찾기
     * @param id
     * @return
     */
    public Board findById(Long id) {
        return store.get(id);
    }

    /**
     * 글 목록 가져오기
     * @return
     */
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }
}
