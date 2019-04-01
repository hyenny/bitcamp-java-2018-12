// 서블릿들이 사용할 객체를 준비하는 서블릿
// => 서블릿이 작업을 수행하려면 XxxService 객체가 필요하다.
// => 서비스 객체는 Spring IoC 컨테이너에 들어 있다.
// => 이 클래스에서 바로 그 Spring IoC 컨테이너를 준비한다.
// => 웹 브라우저와의 통신을 전문적으로 담당할 서버를 도입한다.
// => ServerApp은 Tomcat에서 호출할 수 있도록 규칙에 따라 변경한다.

// 작업
// 1). 톰캣 서버 설치
// => tomcast.apache.org 사이트에서 다운로드 받는다.
// => ~/ server/$톰캐홈
// 2). 자바 웹 프로젝트로 전환
//  => build.gradle 변경
//  =

package com.eomcs.lms;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;

@SuppressWarnings("serial")
@WebServlet(
    urlPatterns = "/init",
    loadOnStartup = 1)
public class InitServlet extends HttpServlet{
  // 보통 클래스에서 사용할 로그 출력 객체는 클래스의 스태틱 멤버로 선언한다.
  final static Logger logger = LogManager.getLogger(InitServlet.class);

  // Command 객체와 그와 관련된 객체를 보관하고 있는 빈 컨테이너
  public static ApplicationContext iocContainer;
  
  // 클라이언트 요청을 처리할 메서드 정보가 들어 있는 객체
  RequestMappingHandlerMapping handlerMapping;
  
 
  @Override
  public void init() throws ServletException {
   
    logger.info("Spring IoC 컨테이너 준비");
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans();
    
    // 스프링 IoC 컨테이너에서 RequestMappingHandlerMapping 객체를 꺼낸다.
    // 이 객체에 클라이언트 요청을 처리할 메서드 정보가 들어 있다.
    handlerMapping = 
        (RequestMappingHandlerMapping) iocContainer.getBean(
            RequestMappingHandlerMapping.class);

  }


  private void printBeans() {
    // 개발하는 동안 참고할 로그는 보통 debug 등급으로 출력한다.
    logger.debug("---------------------------------------------------"); 
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨(객체명=%s ===> 클래스명=%s)", name, 
          iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("---------------------------------------------------"); 
  }
  
  
  
}

