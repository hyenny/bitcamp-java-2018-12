// 요청 핸들러의 아규먼트 - 글로벌 프로퍼티 에디터 적용하기
package bitcamp.app1;

import java.io.PrintWriter;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_6")
public class Controller04_6 {

  
  // 테스트:
  //    http://.../c04_6/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      String model,
      int capacity, 
      boolean auto, 
      Date createdDate // 프로퍼티 에디터를 설정하지 않으면 변환 오류 발생
      ) {

    out.printf("model=%s\n", model);
    out.printf("capacity=%s\n", capacity);
    out.printf("auto=%s\n", auto);
    out.printf("createdDate=%s\n", createdDate);
  }

  //테스트:
  //    http://.../c04_5/h2?car=sonata,5,true,2019-4-19
  @GetMapping("h2") 
  @ResponseBody 
  public void handler2(
      PrintWriter out,
      @RequestParam("car") Car car
      ) {

    out.println(car);
  }
  
  @GetMapping("h3") 
  @ResponseBody 
  public void handler2(
      PrintWriter out,
      // 콤마(,)로 구분된 문자열을 Engine 객체로 변환하기?
      // => String ===> Engine 프로퍼티 에디터를 등록하면 된다.
      @RequestParam("engine") Engine engine
      ) {

    out.println(engine);
  }

}








