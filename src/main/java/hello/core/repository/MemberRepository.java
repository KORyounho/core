package hello.core.repository;

import hello.core.member.Member;

public interface MemberRepository {
    public void save(Member member);

    public Member findById(long memberId);
}
