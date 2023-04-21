package hello.core.member.service;

import hello.core.member.Member;

public interface MemberService {
    public void join(Member member);
    public Member findMember(Long memberId);
}
