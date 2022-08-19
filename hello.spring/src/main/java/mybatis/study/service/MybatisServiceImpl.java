package mybatis.study.service;

import hello.hello.spring.member.Member;
import mybatis.study.repository.MemberMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisServiceImpl implements MybatisService{

    private final MemberMapperRepository memberMapperRepository;

    @Autowired
    public MybatisServiceImpl(MemberMapperRepository memberMapperRepository) {
        this.memberMapperRepository = memberMapperRepository;
    }

    @Override
    public void register(Member member) {
        memberMapperRepository.insert(member);
    }

    @Override
    public Member findById(String id) {
        return memberMapperRepository.findById(id);
    }
}
