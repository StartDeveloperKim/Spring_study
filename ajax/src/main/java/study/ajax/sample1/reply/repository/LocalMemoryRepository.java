package study.ajax.sample1.reply.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import study.ajax.sample1.reply.domain.ReplyVO;

import java.util.List;

@Repository
@Slf4j
public class LocalMemoryRepository {

    // MultiValueMap을 사용한 이유는 댓글에서는 key값의 중복이 발생하기 때문이다.
    private static final MultiValueMap<Long, ReplyVO> store = new LinkedMultiValueMap<>() {};
    private Long seq = 0L;

    public Long insert(ReplyVO vo) {
        vo.setRno(++seq);
        store.add(vo.getBno(), vo); // key : 본 게시물의 아이디, value : 댓글
        return vo.getRno();
    }

    public List<ReplyVO> read(Long rno) {
        return store.get(rno);
    }

    public boolean delete(Long rno) {
        try {
            store.remove(rno);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
