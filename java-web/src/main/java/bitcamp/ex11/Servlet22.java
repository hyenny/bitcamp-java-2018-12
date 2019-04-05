// 세션(session)에서 값 꺼내기 
package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/s22")
@SuppressWarnings("serial")
public class Servlet22 extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    

    HttpSession session = request.getSession();
    
    // 세션의 유효 시간(초)을 설정한다.
    session.setMaxInactiveInterval(30);
    
    session.setAttribute("v1", "aaa");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("v1=%s\n", session.getAttribute("v1"));
    
  }
  
}