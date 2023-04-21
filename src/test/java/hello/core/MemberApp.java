package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        long memberId = 1L;
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(memberId, "nameA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("member.getName() = " + member.getName());
        System.out.println("member.getName() = " + findMember.getName());



//        MemberService memberService = new MemberServiceImpl();
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//        Member findMember = memberService.findMember(1L);
//        System.out.println("member.getName() = " + member.getName());
//        System.out.println("findMember.getName() = " + findMember.getName());
    }
}
