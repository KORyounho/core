package hello.core.order;

import hello.core.discount.DiscountPolicy;

public interface OrderService {
    Order createOrder(Long memberId, String itenName, int itemPrice);
}
