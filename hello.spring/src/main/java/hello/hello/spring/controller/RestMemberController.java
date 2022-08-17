package hello.hello.spring.controller;

import hello.hello.spring.member.Member;
import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMemberController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MemberService memberService;
    @GetMapping("/test")
    public Member test(){
        return memberService.findMember("haha");
    }
}
