package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // DIP를 위반하고 있는 코드
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
