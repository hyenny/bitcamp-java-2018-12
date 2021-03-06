// 세션 다루기 - 
package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c03_1")
public class Controller03_1 {

  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c03_1/h1?name=kim
  @GetMapping(value="h1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(String name, HttpSession session) {
    // HTTPSession 객체를 사용하려면 아규먼트로 받아야 한다.
    
    session.setAttribute("name", name);
    return "세션에 name 보관했음";
  }
  
  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c03_1?age=20
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(int age, HttpSession session) {
    // HTTPSession 객체를 사용하려면 아규먼트로 받아야 한다.
    
    session.setAttribute("age", age);
    return "세션에 age 보관했음";
  }

  
  @GetMapping(value="h3", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(HttpSession session) {
    // HTTPSession 객체를 사용하려면 아규먼트로 받아야 한다.
    
    return String.format("name=%s, age=%s",
        session.getAttribute("name"),
        session.getAttribute("age"));
  }
  
  @GetMapping(value="h4", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler4(HttpSession session) {
    // HTTPSession 객체를 사용하려면 아규먼트로 받아야 한다.
    
    // 세션을 무효화시키기
    session.invalidate();
    
    return "세션을 무효화시켰음!";
  }
  

}

