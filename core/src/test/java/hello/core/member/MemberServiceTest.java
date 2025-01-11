package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        // AppConfig 객체 생성
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    // MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given : ~ 가 주어졌을 때, (입력)
        Member member = new Member(1L, "Minji", Grade.VIP);

        // when : ~ 했을 때, (조건)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : ~ 된다 (결과/검증)
        Assertions.assertEquals(member, findMember);
    }
}
