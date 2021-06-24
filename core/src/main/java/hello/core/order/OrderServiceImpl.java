package hello.core.order;

import hello.core.discount.DiscountPoilcy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPoilcy discountPoilcy; // 인터페이스에만 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPoilcy discountPoilcy) {
        this.memberRepository = memberRepository;
        this.discountPoilcy = discountPoilcy;
    }

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
