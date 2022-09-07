package study.ajax.sample1.reply.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.ajax.sample1.reply.domain.ReplyVO;
import study.ajax.sample1.reply.repository.LocalMemoryRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReplyService {

    private final LocalMemoryRepository localMemoryRepository;

    public Long register(ReplyVO vo) {
        log.info("register..... {}", vo);
        return localMemoryRepository.insert(vo); // 댓글 순번인 rno를 반환
    }

    public List<ReplyVO> getList(Long rno) {
        log.info("read..... {}", rno);

        return localMemoryRepository.read(rno);
    }

    public boolean remove(Long rno) {
        return localMemoryRepository.delete(rno);
    }
}
