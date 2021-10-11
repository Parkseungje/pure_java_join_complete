package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 DI 컨테이너")
    void pureContatiner(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른것을 확인(객체를 호출할때마다 메모리에 새로운 객체가 계속 누적됨/ 효율적이지 않음)
        //이렇게 우리가 만들었던 스프링없는 순수한 DI컨테이너인 AppConfig는 요청을 할 때마다 객체를 새로 생성한다.
        //고객 트래픽이 초당 100이 나오면 초당 100개 객체가 생성되고 소멸된다 -> 이는 메모리의 심한 낭비를 유발한다.
        //해결방안은 해당 객체가 딱 1개만 생성되고, 공유하도록 설계하면 된다. -> 싱글톹 패턴
        System.out.println("memberService1 = " + memberService1 );
        System.out.println("memberService1 = " + memberService2 );

        //memberService1 =/= memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 객체 인스턴스의 참조값이 같은것을 확인할 수 있다.
        System.out.println("singletonService1 = "+ singletonService1);
        System.out.println("singletonService2 = "+ singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContatiner(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService1 = " + memberService1 );
        System.out.println("memberService1 = " + memberService2 );

        //memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
