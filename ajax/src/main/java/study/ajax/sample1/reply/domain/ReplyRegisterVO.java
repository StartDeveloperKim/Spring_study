package study.ajax.sample1.reply.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRegisterVO {

    private Long bno;
    private String reply;
    private String replyer;
}
