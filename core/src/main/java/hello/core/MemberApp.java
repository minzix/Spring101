package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig 객체 생성
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        // MemberService 만들기
        // MemberService memberService = new MemberServiceImpl();

        // Member 객체 생성
        Member member = new Member(1L, "Minji", Grade.VIP);
        memberService.join(member); // 생성된 객체를 회원가입시킴

        // 회원가입이 잘 이루어졌는지 확인하는 코드
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName()); // soutv 로 생성하면 출력할 변수 선택 가능
    }
}
