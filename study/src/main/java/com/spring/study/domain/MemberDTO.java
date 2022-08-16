package com.spring.study.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberDTO {

    private String id;
    private String password;
    private String name;
    private String nickname;
    private Date regdate;

    public MemberDTO(String id, String password, String name, String nickname, Date regdate) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.regdate = regdate;
    }
}
