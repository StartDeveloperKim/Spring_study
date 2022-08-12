package com.spring.study.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
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


    public void setBno(Long bno) {
        this.bno = bno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regdate=" + regdate +
                ", updateDate=" + updateDate +
                '}';
    }
}
