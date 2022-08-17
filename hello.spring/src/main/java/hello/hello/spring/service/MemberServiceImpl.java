package hello.hello.spring.service;

import hello.hello.spring.member.Member;
import hello.hello.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(String memberId) {
        return memberRepository.findById(memberId);
    }
}
