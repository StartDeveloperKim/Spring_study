package com.spring.study.service;

import com.spring.study.domain.RegisterDTO;
import com.spring.study.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRegisterServiceImplTest {

    @Autowired
    MemberRegisterService memberRegisterService;

    @Autowired
    MemberRepository memberRepository;


    @Test
    @DisplayName("회원 등록 서비스 테스트입니다.")
    void MemberRegisterServiceTest(){
        // 중복 아이디 체크 기능을 만들자 --> 버튼 형식
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setId("ms00");
        registerDTO.setPassword("0000");
        registerDTO.setName("김태우");
        registerDTO.setNickname("킹태우");

        memberRegisterService.register(registerDTO);
    }
}