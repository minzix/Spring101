package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 아래의 코드에서 MemberServiceImpl이 MemoryMemberRepository 구현체를 선택해서 생성한 것은 배우가 캐스팅을 하는 것과 같다
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }
}
