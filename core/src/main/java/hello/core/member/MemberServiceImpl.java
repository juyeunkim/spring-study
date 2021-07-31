package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다.
// 오직 AppConfig(외부) 에서 결정된다
// 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다
@Component
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    // 의존관계에 맞는 클래스를 자동으로 주입
    // ex) ac.getBean(MemberRepository.class)
    @Autowired
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
