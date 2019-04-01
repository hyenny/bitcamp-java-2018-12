// 인클루딩(including) - 다른 서블릿의 작업을 포함시키기
package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex07/s11_plus")
@SuppressWarnings("serial")
public class Servlet11_plus extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("게산 결과:");
    
    String op = request.getParameter("op");
    
    RequestDispatcher 요청배달자 = request.getRequestDispatcher("/ex07/s11_error");
    
    if (op.equals("+")) {
      요청배달자 = request.getRequestDispatcher("/ex07/s11_plus");
    } else if (op.contentEquals("-")) {
      요청배달자 = request.getRequestDispatcher("/ex07/s11_minus");
    } else {
      요청배달자 = request.getRequestDispatcher("/ex07/s11_error");
    }
    
    요청배달자.include(request, response);
    
    out.println("------------------------------------------------------------");
    
    }
}

