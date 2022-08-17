package hello.hello.spring.repository;

import hello.hello.spring.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(String memberId);
}
