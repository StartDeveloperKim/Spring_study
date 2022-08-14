package com.spring.study.repository;

import com.spring.study.domain.RegisterDTO;

public interface MemberRepository {

    public void insert(RegisterDTO registerDTO); // 멤버 등록
}
