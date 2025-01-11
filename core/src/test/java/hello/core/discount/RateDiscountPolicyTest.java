package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    // 테스트할 클래스의 객체 생성
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP등급의 고객은 10% 할인이 되어야 한다") // 테스트의 이름 지정 가능
    void vip_o() {
        // given
        Member member = new Member(1L, "minjiVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        Assertions.assertEquals(1000, discount);
    }

    @Test
    @DisplayName("BASIC 등급의 고객은 10% 할인이 되어서는 안된다.") // 테스트의 이름 지정 가능
    void vip_x() {
        // given
        Member member = new Member(2L, "minjiBasic", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        Assertions.assertEquals(0, discount);
    }
}