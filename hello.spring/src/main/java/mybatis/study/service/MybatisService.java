package mybatis.study.service;

import hello.hello.spring.member.Member;

public interface MybatisService {

    public void register(Member member);

    public Member findById(String id);
}
