package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    // member와 상품 가격 input시, 할인 금액 return
    int discount(Member member, int price);
}
