// 서블릿 만들기 - javax.servlet.http.HttpServlet 추상 클래스 상속
package bitcamp.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet 추상 클래스
// => javax.servlet.GenericServlet 추상 클래스를 상속 받았다.
// => service() 메서드도 구현했다.
// => service() 메서드는 웹브라우저가 요청한 명령에 따라
//      doGet(), doPost(), doHead(), doPut() 등을 호출하게 프로그램 되어 있다.
// => HTTP 프로토콜을 다루려면 GenericServlet을 상속 받지 말고
//      

public class Servlet03 extends HttpServlet{
  // GenesicServlet 추상 클래스가 java.io.Serialize 인터페이스를 구현하였고,
  // HttpServlet 클래스가 GenericServlet 추상 클래스를 상속 받았으니
  // HttpServlet 클래스를 상속 받는 이 클래스도 마찬가지로
  // serialVersionUID 변수 값을 설정해야 한다. 
  private static final long serialVersionUID = 1L;
  
  // service()를 오버라이딩 하는 대신에
  // doGet(), doPost(), doHead() 등을 오버라이딩 하라.
  
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //super.doGet(req, resp);
    System.out.println("Servlet03.doGet(HttpServletRequest, HttpServletResponse)"); 
  }


 

}
