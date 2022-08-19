package mybatis.study.repository;

import hello.hello.spring.member.Member;
import mybatis.study.service.MybatisService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MemberMapperRepositoryTest {

    private MemberMapperRepository memberMapperRepository;
    private final MybatisService mybatisService;

    @Autowired
    MemberMapperRepositoryTest(MemberMapperRepository memberMapperRepository, MybatisService mybatisService) {
        this.memberMapperRepository = memberMapperRepository;
        this.mybatisService = mybatisService;
    }

    @Test
    @DisplayName("Mybatis Test")
    void MybatisTest(){
        Member member = new Member("하하하", "1234", "나나나");

        mybatisService.register(member);

        Member result = mybatisService.findById("최홍만");
        System.out.println(result.toString());
    }
}