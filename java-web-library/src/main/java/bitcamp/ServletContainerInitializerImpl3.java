package bitcamp;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

// 만약 서블릿 컨테이너에게 특정 타입의 객체를 찾아 보고하라고 지정하고 싶다면
// 다음 애노테이션을 사용하여 찾고자 하는 타입을 알려줘라!
//
@HandlesTypes(ApplicationInitializer.class)
public class ServletContainerInitializerImpl3
  implements ServletContainerInitializer{

  @Override
  public void onStartup(Set<Class<?>> types, ServletContext ctx) throws ServletException {
    // 이 메서드는 서블릿 컨테이너가 시작될 때 자동 호출될 것이다. 
    System.out.println("ServletContainerInitializerImpl3.onStartup()... 호출됨!");
    
    // 파라미터 c는 @HandlesTypes으로 지정한 클래스 목록이다.
    // 서블릿 컨테이너는 onStartUp() 메서드를 호출할 때
    // 이 애노테이션이 지정한 클래스를 찾아 파라미터로 넘겨준다.
    System.out.println("ApplicationInitializer 구현체 목록: ");
    for (Class<?> type : types) {
      System.out.println("====> " + type.getName());
      try {
      ApplicationInitializer obj =
          (ApplicationInitializer) type.getConstructor().newInstance();
      } catch (Exception e) {
        
      }
    }
    
    
  }

}
