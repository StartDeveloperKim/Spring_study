package study.ajax.sample1.reply.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {

    private Long rno;
    private Long bno;

    private String reply;
    private String replyer;
    private Date replyDate;

    public ReplyVO(Long bno, String reply, String replyer, Date replyDate) {
        this.bno = bno;
        this.reply = reply;
        this.replyer = replyer;
        this.replyDate = replyDate;
    }
}
