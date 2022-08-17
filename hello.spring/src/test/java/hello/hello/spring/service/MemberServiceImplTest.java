package hello.hello.spring.service;

import hello.hello.spring.config.AppConfig;
import hello.hello.spring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemberServiceImplTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("memberTest")
    void memberTest(){
        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member("kim", "1234");
        Member member1 = new Member("choi", "0000");
        Member member2 = new Member("jang", "0000");

        memberService.join(member);
        memberService.join(member1);
        memberService.join(member2);

        System.out.println("memberService.findMember(kim) = " + memberService.findMember("kim").toString());
        Assertions.assertThat(memberService.findMember(member.getId())).isEqualTo(member);
    }
}