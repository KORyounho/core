package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        Member member = new Member(1L, "nameA", Grade.VIP);
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        System.out.println("findmember = " + member.equals(findmember));
    }
}
