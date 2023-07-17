package hello.core.member.repository;

import hello.core.member.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{

    //----------------------------수정 후---------------
    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이슈때문에 ConcurrentHashMap을 사용함 -> 실무에서 사용
    private static final long sequence = 0L;
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
