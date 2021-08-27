package hello.core.Order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
//Qualifier("xxx"): 동일한 Qualifier(xxx)끼리 찾아서 주입한다.
    public OrderServiceImpl(MemberRepository memberRepository,  @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    private final MemberRepository memberRepository;//생성자주입에서는 final을 넣을수 있는데, final넣으면 1.생성자에서만 값을 넣을 수있음& 2.생성자를 만들지않으면 넣어야한다고 컴파일오류가난다.->좋다
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memberId);
       int discountPrice = discountPolicy.discount(member,itemPrice);

       return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
