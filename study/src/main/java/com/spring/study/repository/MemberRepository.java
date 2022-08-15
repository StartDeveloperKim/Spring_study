package com.spring.study.repository;

import com.spring.study.domain.RegisterDTO;

public interface MemberRepository {

    public void insert(RegisterDTO registerDTO); // 멤버 등록

    public boolean checkIdDuplicate(String id); // 아이디 중복체크
}
