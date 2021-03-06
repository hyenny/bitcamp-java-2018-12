//  쿠키 읽기 - 유효기간이 설정된 쿠키 읽기
package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s12")
@SuppressWarnings("serial")
public class Servlet12 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex10/s12
    
   
    Cookie[] cookies = request.getCookies();
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    if (cookies != null) {
      for (Cookie c : cookies) {
        out.printf("%s=%s\n", c.getName(), c.getValue());
      }
      
    }
    
    
   
  }
}