package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.repository.MemoryMemberRepository;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

//@Configuration을 사용 안해도 스프링 빈 등록은 가능하지만, 싱글톤 보장을 하진 못함.
//@Configuration을 통해서 바이트 코드를 조작해서 싱글톤을 보장하지만, 만약 그러지 못하면 ConfigurationSingletionTest에서 결과물이
// memoryMemberRepository가 3번 호출되고, 세게의 인스턴스는 전부 다르게 나올거임.
// @Configuration을 사용하면, 이미 한번의 객체를 생성했기에, 내부코드에서 memoryMemberRepository가 이미 컨테이너에 빈으로 등록되어져있기에
// 새로운 인스턴스를 생성하지 않을것임
public class AppConfig { // AppConfig는 구성영역, 나머지 부분은 사용 영역 // 코드 리팩토링시 사용영역만 고쳐야함
    /* -------------------------- 보기 편하게 하기 위한 작업 ---------------------------
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    이 작업은 new MemoryMemberRepository()가 중복으로 사용되기에 저 코드부분을 드래그해서 ctrl+alt+m을 눌러서
    아래와 같이 변경시킴
    */
    //---------------------------------변경후-------------------------------
    //@Bean("mmm") 이런식으로 이름을 바꿀 수 있긴 함. 근데 거의 안바꾸고, 반약에 바꾼다면 applicationContext.getBean(이름,클래스)
    // 에서 이름부분을 "mmm"으로 변경해야함
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    //--------------------------------아래꺼ㅗ도 다 변경함-----------------------------
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
