// 세션 다루기 - 
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c05_1")
public class Controller05_1 {
  
  ArrayList<Board> list = new ArrayList<>();
  
  public Controller05_1() {
    list.add(new Board(1, "제목입니다1", "내용", "홍길동", 10, Date.valueOf("2019-05-01")));
    list.add(new Board(2, "제목입니다2", "내용", "홍길동2", 11, Date.valueOf("2019-06-01")));
    list.add(new Board(3, "제목입니다3", "내용", "홍길동3", 12, Date.valueOf("2019-07-01")));
    list.add(new Board(4, "제목입니다4", "내용", "홍길동4", 13, Date.valueOf("2019-08-01")));
    list.add(new Board(5, "제목입니다5", "내용", "홍길동5", 14, Date.valueOf("2019-09-01")));
    list.add(new Board(6, "제목입니다6", "내용", "홍길동6", 15, Date.valueOf("2019-10-01")));
    list.add(new Board(7, "제목입니다7", "내용", "홍길동7", 19, Date.valueOf("2019-11-01")));
    list.add(new Board(8, "제목입니다8", "내용", "홍길동8", 20, Date.valueOf("2019-12-01")));
    list.add(new Board(9, "제목입니다9", "내용", "홍길동9", 1, Date.valueOf("2019-01-01")));
    list.add(new Board(10, "제목입니다10", "내용", "홍길동10", 3, Date.valueOf("2019-02-01")));
    list.add(new Board(11, "제목입니다11", "내용", "홍길동11", 5, Date.valueOf("2019-03-01")));
  }

  // 1) JSP에서 JSON 형식의 콘텐트 출력하기
  
  @GetMapping("h1")
  @ResponseBody
  public void handler1(Model model) {
    model.addAttribute("list", this.list);
  }
  
  /*
  
  // 2)
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2() {
    return new Gson().toJson(this.list);
  }
  
  */
  
  // 3). Google Gson 라이브러리를 사용하여 JSON 형식의 콘텐트 출력하기2
  //  => 페이지 컨트롤러의 리턴 값이 String이 아니면
  //
  @GetMapping("h3")
  @ResponseBody
  public Object handler3() {
    return this.list; //JSON 형식의 문자열은 자동으로 UTF-8로 인코딩 된다.
  }
  
  
  
  
 
}

