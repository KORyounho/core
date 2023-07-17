package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.service.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixDiscountPolicyTest {
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("VIP 정액할인 적용")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닐경우 정액할인 적용 안함")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
