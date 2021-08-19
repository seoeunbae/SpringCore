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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemberRepository(),

    @Bean
    public MemberService memberService() {//키(메소드명)
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());//요것만바꾸면됨//벨류
    }

    @Bean
    public MemoryMemberRepository memberRepository() {//멤버메모리리포지토리리턴하는메소드
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), DiscountPolicy());//요것만바꾸면됨
    }

    @Bean
    public RateDiscountPolicy DiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
