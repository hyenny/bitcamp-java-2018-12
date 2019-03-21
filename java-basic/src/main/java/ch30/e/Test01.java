// AOP 사용 - 기능 추가의 위치
package ch30.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch30/d/application-context-01.xml");
    
    // @Component 애노테이션 붙은 클래스의 인스턴스를 자동으로 생성한다. 
    System.out.println("---------------------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n",
          name, iocContainer.getBean(name).getClass().getName());
    }
    
    System.out.println("---------------------------------------");
    
    X x = (X) iocContainer.getBean("x");
    System.out.println(x.calculate(10, 20, "%"));
    
  }
}

