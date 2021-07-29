package hello.core.member;

// MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다.
// 오직 AppConfig(외부) 에서 결정된다
// 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
