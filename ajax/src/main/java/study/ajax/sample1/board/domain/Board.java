package study.ajax.sample1.board.domain;

import lombok.Data;

@Data
public class Board {

    private Long id; // 글의 아이디, PK(Primary Key), 댓글 테이블에서의 FK(Foreign Key)
    private String title;
    private String content;
    private String writer;

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
