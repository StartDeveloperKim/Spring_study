/*UpdateDTO를 따로 제작해서 좀 더 새분화를 시킬까 한다. */

package com.spring.study.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class UpdateDTO {

    private Long bno;
    private String title;
    private String content;
    private Date updateDate;

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }
}
