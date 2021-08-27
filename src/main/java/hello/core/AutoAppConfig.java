package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
        //애노테이션타입,configuration인 애는 제외, Appconfig는 수동으로 등록하는건데, 자동으로 등록되면 안되기 때문! (Configuration애노테이션안에 Component애노테이션이 들어있다.)
        //->실무에서는 excludeFilter@Configuration하지 않지만, 지금은 앞선 예제코드를 살리기 위해서 사용함
        //@Bean,@Configuration은 수동으로 스프링빈등록
        //@ComponentScan, @Component, @Controller, @Service @Repository, @Configuration는 자동으로 스프링빈등록,@Autowired으로 자동 의존관계설정
        //basePackages = "hello.core",//지정위치의 하위만 스캔한다.(어디서부터시작해서 찾는지 지정하는것)
        //basePackageClasses = AutoAppConfig.class//지정클래스의 패키지를 탐색시작위치로 지정하는것
)
public class AutoAppConfig {
}
