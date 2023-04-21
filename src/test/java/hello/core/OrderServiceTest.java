package hello.core;

import hello.core.order.Order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        Member member2 = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(member);
        memberService.join(member2);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Order order2 = orderService.createOrder(2L, "itemB", 20000);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);
    }
}
