package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig 객체 생성
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // Spring 사용에 필요한 코드 추가
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // memberService와 같이 getBean에서 이름을 설정하는 문자열은 앞서 AppConfig에 정의된 메소드 이름과 일치시켜야 함
        // 즉, [타입] [이름] = applicationContext.getBean("[이름]", [타입].class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // Member 객체 생성
        Member member = new Member(1L, "Minji", Grade.VIP);
        memberService.join(member); // 생성된 객체를 회원가입시킴

        // 회원가입이 잘 이루어졌는지 확인하는 코드
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName()); // soutv 로 생성하면 출력할 변수 선택 가능
    }
}
