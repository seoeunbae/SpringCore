package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {//키(메소드명)
        return new MemberServiceImpl(MemberRepository());//요것만바꾸면됨//벨류
    }

    @Bean
    public MemoryMemberRepository MemberRepository() {//멤버메모리리포지토리리턴하는메소드
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());//요것만바꾸면됨
    }

    @Bean
    public RateDiscountPolicy DiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
