// 서블릿 초기화 파라미터 - 애노테이션으로 설정하기
package bitcamp.ex06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿이 사용할 값을 DD 설정으로 지정할 수 있다. 
@WebServlet(
    value="/ex06/s3",
    loadOnStartup=1,
    initParams={
        @WebInitParam(name="jdbc.driver", value="org.mariadb.jdbc.Driver"),
        @WebInitParam(name="jdbc.url", value="jdbc:mariadb://localhost/bitcampdb"),
        @WebInitParam(name="jdbc.username", value="bitcamp"),
        @WebInitParam(name="jdbc.password", value="1111")
})
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {
  
  @Override
  public void init() throws ServletException {
    // 클라이언트가 서블릿의 실행을 요청할 때 서블릿 객체가 없으면 생성된다.
    // 서블릿 객체가 생성될 때 이 메서드가 호출된다.
    System.out.println("/ex06/s1 => init()");
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    ServletConfig config = this.getServletConfig();
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.printf("driver=%s\n", config.getInitParameter("jdbc.driver"));
    out.printf("url=%s\n", config.getInitParameter("jdbc.url"));
    out.printf("username=%s\n", config.getInitParameter("jdbc.username"));
    out.printf("password=%s\n", config.getInitParameter("jdbc.password"));
     
    System.out.println("/ex06/s1 => sevice()");
    
  }
 
}

