package com.spring.study.domain;

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Critertia{" +
                "pageNum=" + pageNum +
                ", amount=" + amount +
                '}';
    }
}

