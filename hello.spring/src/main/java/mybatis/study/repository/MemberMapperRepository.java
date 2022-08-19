package mybatis.study.repository;

import hello.hello.spring.member.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapperRepository {

    @Insert("INSERT INTO MEMBER2 (ID, PASSWORD, NAME) VALUES (${id}, ${password}, ${name}")
    public void insert(Member member);

    @Select("select * from member2 where id = ${id}")
    public Member findById(String id);
}
