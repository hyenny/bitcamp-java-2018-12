package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/c01_1") 
public class Controller01_1 {
  
  @GetMapping("h1") 
  public String handler() {
    // InternalResourceViewResolver를 사용하여
    // JSP URL의 접두어와 접미사를 미리 설정해 둘 수 있다.
    // 
    return "c01_1";
  }
  
  
  

}
