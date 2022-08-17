package hello.hello.spring.repository;

import hello.hello.spring.member.Member;

import java.util.HashMap;
import java.util.Map;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private Map<String, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(String memberId) {
        return store.get(memberId);
    }
}
