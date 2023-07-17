package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("정률 할인 정책 // VIP는 10%할인이 적용되어야한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 20000) ;
        //then
        Assertions.assertThat(discount).isEqualTo(2000);
    }
    @Test
    @DisplayName("VIP가 아닌경우")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 20000) ;
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}
