package hello.core;

import hello.core.discount.DiscountPoilcy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
 * 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다
 * 역할과 구현 클래스가 한눈에 들어온다 => 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악 가능
 * */
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPoilcy());
    }

    public DiscountPoilcy discountPoilcy(){
//        return new FixDiscountPolicy();
//        구현하려는 대상을 바꾸려면 해당 코드만 바꾸면된다 => OrderServiceImpl의 어떠한 코드도 변경할 필요가 없다
        return new RateDiscountPolicy();
    }

}
