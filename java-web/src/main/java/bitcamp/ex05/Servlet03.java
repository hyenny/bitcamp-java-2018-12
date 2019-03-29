// HTTP 프로토콜 다루기 - 
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s3")
public class Servlet03 extends MyHttpServlet2 {
  
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // HttpServletRequest에는 HTTP 프로토콜의 요청 방식을 리턴하는 메서드가 있다.
    // => HttpServletRequest.getMethod()
    //
    if (request.getMethod().equals("GET")) {
      out.println("GET 요청입니다.");
      
    } else if (request.getMethod().equals("POST")) {
      out.println("POST 요청입니다.");
      
    } else {
      out.println("이 서블릿이 다루지 못하는 요청 방식입니다.");
    }
    
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset='UTF-8'");
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    super.doPost(request, response);
  }
}

