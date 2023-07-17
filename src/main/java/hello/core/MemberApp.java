package hello.core;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //----------------스프링 사용 안하는 경우 --------------
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //---------------스프링 사용 하는 경우---------------
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
      //요부분은 스프링 컨테이너를 불러옴 == 컨테이너  // 이부분은 @ Configration이 되어져잇는 부분을 찾음. AppConfig.class파일 안에
                                                    // @Bean이 되어져 있는 메서드들을 전부 스프링 빈에 등록시킴
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
      //                                  // 이름        //타입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
