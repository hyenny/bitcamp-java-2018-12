package ch29.j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// @Configuration
// => AnnotationConfigApplicationContext 컨테이너에 클래스를 직접 지정할 경우에는
//      예) ApplicationContext = iocContainer = 
//                    new AnnotationConfigApplicationContext(Appconfig1.class);
   
                    
@Configuration
@ComponentScan({"ch29.j2"})
public class AppConfig2 {

}
