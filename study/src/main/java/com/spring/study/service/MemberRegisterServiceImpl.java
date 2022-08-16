package com.spring.study.service;

import com.spring.study.domain.RegisterDTO;
import com.spring.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberRegisterServiceImpl implements MemberRegisterService {

    private final MemberRepository memberRepository;

    @Override
    public void register(RegisterDTO registerDTO) {
        memberRepository.insert(registerDTO);
    }
}
