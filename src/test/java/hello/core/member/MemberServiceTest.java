package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //-----------------------기존 코드----------------------
    //MemberService memberService = new MemberServiceImpl();

    /*----------------------2번째 수정 이전 코드 -----------------
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

     */
    MemberService memberService;
    @BeforeEach // 해당 어노테이션 먼저 함수 실행.
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        Member member = new Member(1L, "nameA", Grade.VIP);
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        System.out.println("findmember = " + member.equals(findmember));
    }
}
