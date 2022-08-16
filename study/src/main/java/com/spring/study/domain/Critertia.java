package com.spring.study.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Critertia {

    private int pageNum;
    private int amount;

    public Critertia() {
        this(1, 10);
    }

    public Critertia(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}

