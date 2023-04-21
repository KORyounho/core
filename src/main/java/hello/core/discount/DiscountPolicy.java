package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
