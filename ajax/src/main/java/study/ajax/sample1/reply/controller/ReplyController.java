package study.ajax.sample1.reply.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.ajax.sample1.reply.domain.ReplyRegisterVO;
import study.ajax.sample1.reply.domain.ReplyVO;
import study.ajax.sample1.reply.service.ReplyService;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/replies")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody ReplyRegisterVO registerVO) {
        log.info("ReplyVO: {}", registerVO);

        ReplyVO vo = new ReplyVO(registerVO.getBno(), registerVO.getReply(), registerVO.getReplyer(), new Date());

        Long insertCount = replyService.register(vo);

        log.info("Reply INSERT COUNT: {}", insertCount);

        return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{bno}")
    public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno) {

        log.info("getList.........");
        return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);
    }
}
