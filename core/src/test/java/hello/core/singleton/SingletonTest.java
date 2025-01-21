package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때마다 객체를 생성하는지를 조회
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때마다 객체를 생성하는지를 조회
        MemberService memberService2 = appConfig.memberService();

        // ➡️ 1번과 2번의 참조값이 다른 것을 확인하기
        // System.out.println("memberService1 = " + memberService1);
        // System.out.println("memberService2 = " + memberService2);
        Assertions.assertNotSame(memberService1, memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        // AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회: 호출할 때마다 객체를 생성하는지를 조회
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회: 호출할 때마다 객체를 생성하는지를 조회
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // ➡️ 1번과 2번의 참조값이 같은 것을 확인하기
        // System.out.println("memberService1 = " + memberService1);
        // System.out.println("memberService2 = " + memberService2);
        Assertions.assertEquals(memberService1, memberService2);
    }
}
