package com.spring.study.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;

    public BoardVO() {
    }

    public BoardVO(String title, String content, String writer, Date regdate, Date updateDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regdate = regdate;
        this.updateDate = updateDate;
    }
}
