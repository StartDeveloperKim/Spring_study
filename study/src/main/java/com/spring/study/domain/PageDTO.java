package com.spring.study.domain;

public class PageDTO {

    private int startPage;
    private int endPage;
    private boolean prev, next;

    private int total;
    private Critertia cri;

    public PageDTO(Critertia cri, int total) {
        this.cri = cri;
        this.total = total;

        this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
        // 현재 페이지 번호에서 10으로 나눈 몫을 구하고 올림처리한 뒤 10을 곱하면 마지막페이지가 나온다.
        this.startPage = this.endPage - 9;
        // 시작페이지는 마지막페이지에서 9를 빼면된다(페이지 10개씩 보여준다고 가정)

        int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
        // total에서 페이지 크기만큼 곱하면 ㄹㅇ 마지막 페이지이다.

        if (realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        // 이전과 다음이 있냐 없냐는 boolen 타입으로 정한다.
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getTotal() {
        return total;
    }

    public Critertia getCri() {
        return cri;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", total=" + total +
                ", cri=" + cri +
                '}';
    }
}
