package hello.hello.spring.service;

import hello.hello.spring.member.Member;
import hello.hello.spring.repository.JdbcTemplateMemberRepository;
import hello.hello.spring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

class MemberServiceImplTest {

    JdbcTemplate jdbcTemplate;
    MemberRepository memberRepository = new JdbcTemplateMemberRepository(jdbcTemplate);
    MemberService memberService = new MemberServiceImpl(memberRepository);

    @Test
    @DisplayName("memberTest")
    void memberTest(){

        Member member = new Member("kim", "1234", "김태우");
        Member member1 = new Member("choi", "0000", "최민석");
        Member member2 = new Member("jang", "0000", "장우석");

        memberService.join(member);
        memberService.join(member1);
        memberService.join(member2);

        System.out.println("memberService.findMember(kim) = " + memberService.findMember("kim").toString());
        Assertions.assertThat(memberService.findMember(member.getId())).isEqualTo(member);
    }

    @Test
    @DisplayName("LookUP Member")
    void lookupTest(){
        Member haha = memberService.findMember("haha");
        System.out.println("haha = " + haha.toString());
    }
}