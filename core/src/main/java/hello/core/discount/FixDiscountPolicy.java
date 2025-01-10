package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    // 우선은 고정금액인 1000원을 할인해주기로 했으므로, 멤버변수로 선언하자
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) { // 할인할 금액 반환 (할인된 금액과 혼동 X)
        // VIP 회원일 경우,
        if (member.getGrade() == Grade.VIP){
            // 1000원(고정금액) 할인 적용
            return discountFixAmount;
        }
        return 0;
    }
}
