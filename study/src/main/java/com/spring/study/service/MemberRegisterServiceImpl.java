package com.spring.study.service;

import com.spring.study.domain.RegisterDTO;
import com.spring.study.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberRegisterServiceImpl implements MemberRegisterService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberRegisterServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        memberRepository.insert(registerDTO);
    }
}
