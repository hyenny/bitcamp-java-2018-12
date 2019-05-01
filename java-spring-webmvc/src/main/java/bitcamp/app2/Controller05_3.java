
package bitcamp.app2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c05_3")
public class Controller05_3 {
  
  // 1) 낱개의 데이터 입력 받기
  // 테스트  : http://localhost:8080/java-spring-webmvc/app2/c05_3/h1?no=1&title=ok&writer=kim&viewCount=100
  

  @RequestMapping(value="h1", produces="text/plain;charset=UTF-8")
  public Object handler1(
      int no,
      String title,
      String writer,
      int viewCount) {
  
    return String.format("%d, %s, %s, %d", no, title, writer, viewCount); 
  }
  
  @RequestMapping(value="h2", produces="text/plain;charset=UTF-8")
  public Object handler1(Board board) {
  
    return board.toString(); 
  }
  
  // 3) JSON 형식의 요청 파라미터 값을 통째로 문자열로 받기
  // 테스트 .../html/app2/c05_3_h3
  @RequestMapping(value="h3", produces="text/plain;charset=UTF-8")
  public Object handler3(@RequestBody String content) {
    System.out.println(content);
    return "OK!"; 
  }
  
  
  @RequestMapping(value="h5", produces="text/plain;charset=UTF-8")
  public Object handler5(@RequestBody Board content) {
    System.out.println(content);
    
    // 주의!
    // => 클라이언트에서 보낸 날짜 데이터의 문자 형식이 yyyy-MM-dd 형태여야 한다.
    //    그래야 java.util.Date 타입의 값으로 변환해 준다.
    //    예) 2019-05-01 ====> java.util.Date 객체 변환 성공!
    // => 만약 이 형태가 아니면 변환할 수 없어 실행 오류가 발생한다.
    //    예) 2019-5-1 ==> 변환 오류!
    //
    // @JsonFormat 애노테이션 사용
    // => 도메인 객체의 프로퍼티에 이 애노테이션을 붙이면
    //    2019-05-01 이나 2019-5-1 모두 처리할 수 있다.
    // => 뿐만 아니라, 도메인 객체를 JSON 문자열로 변환할 때도
    //    해당 형식으로 변환한다.
    return "OK!"; 
  }
  
  
  
}

