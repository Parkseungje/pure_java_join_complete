package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 싱글톤(객체 한개의 주소값을 공유해서 쓸수있는것)으로 사용가능
@ComponentScan( // @Component 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class
        )
)
public class AutoAppConfig {


}
