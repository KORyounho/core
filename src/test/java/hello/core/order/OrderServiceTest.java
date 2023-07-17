package hello.core.order;

import hello.core.AppConfig;
import hello.core.order.Order;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    /* --------------------------------수정 전 -------------
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
     */
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(1L, "itemA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order.toString = " + order.toString());


    }

}


