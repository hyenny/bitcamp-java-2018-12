// 리프레시 - 클라이언트에게 다른 URL을 요청하라는 명령
package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/s3")
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex08/s3
    //
    // 리다이렉트
    // => 클라이언트의 요청을 받은 후 콘텐트를 보내는 대신
    //    다른 페이지의 URL을 알려줄 때 사용한다.
    // => 웹 브라우저는 응답 받는 즉시 해당 페이지를 요청한다.
    //    웹 서버로부터 콘텐트를 받지 않았기 때문에 어떤 것도 출력하지 않는다.
    //    바로 다른 페이지로 이동한다. 
    // => 리프레시와 달리 서버트는 콘텐트(message body)를 보내지 않는다.
    // => 사용 예:
    //      로그인 후 로그인 결과를 출력하지 않고 즉시 메인 화면ㅇ로 보내고 싶을 때
    //      결제완료 후 결과를 출력하지 않고 즉시 결제 상태 페이지로 보내고 싶을 때
    // => 리다이렉트 
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("안녕하세요! - /ex08/s3");
    
    out.println("<html><head>");
    out.println("<title>리다이렉터</title>");
    out.println("</head><body>");
    
    //for (int i=0; i <3000; i++) {
      out.println("안녕하세요! - /ex08/s3");
      
    //}
    out.println("</body><html>");
    
    // 클라이언트에게 URL을 알려줄 때 상대 경로를 지정할 수 있다.
    // forward/include와 달리 '/'는 컨텍스트 루트가 아닌
    // 웹 서버 루트를 의미한다.
    
    response.sendRedirect("s100");
    
    // 리다이렉트를 하는 순간 이전까지 버퍼로 출력된 내용은 모두 버려진다.
    // 왜? 리다이렉트는 클라이언트로 콘텐트를 보내지 않는다.
    //
    // 만약 출력한 내용이 버퍼를 꽉 채워서 자동으로 응답을 헀다면 어떻게 되나요?
    // => 이미 응답했기 때문에 리다이렉트는 동작되지 않는다. 
    
    
  }
}