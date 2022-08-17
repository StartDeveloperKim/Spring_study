package hello.hello.spring.service;

import hello.hello.spring.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(String memberId);
}