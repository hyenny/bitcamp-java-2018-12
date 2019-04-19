// 요청 핸들러에서 view 컴포넌트(JSP) 쪽에 데이터 전달하기
package bitcamp.app1;

import java.util.Map;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/c05_3") 
public class Controller05_3 {

  @GetMapping("h1")
  public String handler1(
      ServletRequest request) {
    
    // JSP가 꺼내 쓸 수 있도록 ServletRequest 객체에 직접 담는다.
    request.setAttribute("name", "홍길동");
    request.setAttribute("age", 20); //auto-boxing
    request.setAttribute("working", true); //auto-boxing
    
    
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  @GetMapping("h2")
  public String handler2(
      Map<String,Object> map) {
    
    // 아규먼트에 Map 타입의 변수를 선언하면
    // 프론트 컨트롤러는 맵 객체를 만들어 넘겨준다.
    // 이 맵 객체의 용도는 JSP에 전달할 값을 담는 용이다.
    // 맵 객체에 값을 담아 놓으면 프론트 컨트롤러가 JSP를 실행하기 전에
    // ServletRequest로 복사한다.
    // 따라서 ServletRequest에 값을 담는 것과 같다.
    
    map.put("name", "홍길동");
    map.put("age", 20);
    map.put("working", false);
    
    
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  @GetMapping("h3")
  public String handler3(
      Model model) {
    
    // 아규먼트에 Model 타입의 변수를 선언하면
    // 프론트 컨트롤러는 모델 객체를 만들어 넘겨준다.
    // 이 객체의 용도는 Map 객체와 같다. 
    //
    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);
    model.addAttribute("working", true);
    
    return "/WEB-INF/jsp/c05_3.jsp";
  }
 
  
  
  
}
