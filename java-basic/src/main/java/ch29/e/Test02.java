package ch29.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/e/application-context-02.xml");
    
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
  }
}

