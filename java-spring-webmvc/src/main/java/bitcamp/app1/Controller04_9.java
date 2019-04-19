// 요청 핸들러의 아규먼트 - @RequestBody
package bitcamp.app1;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_9")
public class Controller04_9 {
  
  // 클라이언트가 보낸 데이터를 통째로 받기
  // => request handler의 아규먼트 앞에 @RequestBody를 붙이면 된다.
  
  @PostMapping(value="h1", produces="text/html;charset=UTF-8") 
  @ResponseBody 
  public void handler1(
      String name,
      int age,
      // 클라이언트가 보낸 데이터를 통째로 받으려면 @RequestBody 애노테이션을 붙인다.
      @RequestBody String data
      ) throws Exception {
    
    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    
    out.println("<html><head><title>c04_9/h1</title></head><body>");
    out.println("<h1>결과</h1>");
    out.println("<p>이름:" + name + "</p>");
    out.println("<p>나이:" + age + "</p>");
    out.println("<p>통데이터:" + data + "</p>");
    out.println("</body></html>");
   

  }

 

}








