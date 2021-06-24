package hello.core.order;

import hello.core.discount.DiscountPoilcy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPoilcy discountPoilcy = new FixDiscountPolicy();
    private final DiscountPoilcy discountPoilcy = new RateDiscountPolicy();
    // ==> DIP 위반: OrderServiceImpl이 인터페이스뿐만아니라 구현 클레스에도 의존하고 있다
    // ==> OCP 위반: DisCountPolicy를 수정하면 OrderServiceImpl의 코드도 수정해야한다 !!

    @Override
    public Order createOrder(Long memerId, String itemName, int itemPrice) {
        // 1. 회원 정보를 조회
        Member member = memberRepository.findById(memerId);
        // 2. 할인정책을 조회
        int discountPrice =  discountPoilcy.discount(member, itemPrice);

        // 3. 주문 객체를 넘긴다
        return new Order(memerId, itemName, itemPrice, discountPrice);
    }
}
