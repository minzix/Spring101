package hello.core.member;
// 회원서비스(MemberService): 회원가입, 회원조회 기능
public interface MemberService {
    // 회원가입
    void join(Member member);

    // 회원조회
    Member findMember(Long MemberId);
}
