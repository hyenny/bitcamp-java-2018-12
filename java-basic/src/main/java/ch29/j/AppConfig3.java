package ch29.j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

                    
//@Configuration // 스프링 IoC 컨테이너에게 이 클래스를 직접 알려주지 않기 때문에 
@ComponentScan(
    basePackages={"ch29.j2","ch29.j"},
    excludeFilters=@ComponentScan.Filter(
        type=FilterType.REGEX,
        pattern="ch29.j.Car"
        )
    )
public class AppConfig3 {

}
