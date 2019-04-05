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

@WebServlet("/ex11/s2")
@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex11/s2
    
    // 세션 아이디 보내기
    // => 서버로부터 세션 아이디 쿠키를 받은 웹 브라우저는 해당 서버에 요청할 때마다
    //      세션 아이디 쿠키를 보낸다.
    // => HTTP 요청 프로토콜
    //
 
        //GET /java-web/ex11/s2 HTTP/1.1
        //Host: localhost:8080
        //Connection: keep-alive
        //Pragma: no-cache
        //Cache-Control: no-cache
        //Upgrade-Insecure-Requests: 1
        //User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
        //Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
        //Accept-Encoding: gzip, deflate, br
        //Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
        //Cookie: name=hong; age=20; working=true; name2=홍길동; name3=%ED%99%8D%EA%B8%B8%EB%8F%99; JSESSIONID=2A6E6A99BE189D1785B9BD5E1DE8225F

    // 세션 생성하기
    // 1). 클라이언트가 세션 아이디를 쿠키로 전송
    //      - 서버에서는 해당 아이디의 세션을 찾는다.
    //      - 있으면, 그 세션을 리턴한다.
    //      - 있는데 세션의 유효 기간이 지났다면, 새로 세션을 만들어 리턴한다.
    //      - 없다면, 새로 세션을 만들어 리턴한다.
    // 2). 클라이언트가 세션 아이디를 보내지 않은 경우
    //      - 서버는 새 세션을 만들어 리턴한다.
    //
    // 항상 새 세션을 만들면, 응답할 때 새 세션의 아이디를 쿠키로 보낸다.
    //
    HttpSession session = request.getSession();
 
  
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // 세션에서 값 꺼내기
    // => 웹 브라우저를 종료한 후 다시 실행하면 이전에 /ex11/s1을 실행했을 때
    //    서버로부터 받은 세션 아이디 쿠키가 삭제된다.
    // => 그런 후에 웹 브라우저에서 이 서블릿을 요청하면
    //    getSession() 메서드를 새 세션 객체를 생성한 후 리턴한다.
    //      따라서 새 세션에는 v1이라는 이름으로 저장된 값이 없기 때문에
    //      null을 출력할 것이다.
    //
    out.printf("v1=%s\n", session.getAttribute("v1"));
    
  }
}