package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    // 인터페이스 인스턴스들 생성
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        // 조회한 회원정보와 input받은 물건 가격을 사용해서 할인해야 할 금액 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 금액을 할인이 적용된 금액으로 변경해서 새로운 Order 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도로 추가한 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
