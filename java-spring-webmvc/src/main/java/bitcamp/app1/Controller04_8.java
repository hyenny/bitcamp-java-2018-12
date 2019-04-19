
package bitcamp.app1;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/c04_8")
public class Controller04_8 {
  
  // ServletContext는 메서드의 아규먼트로 받을 수 없다. 
  @Autowired ServletContext sc;

  // 클라이언트가 멀티파트 형식으로 전송한 데이터를 꺼내기
  // => MultipartFile 타입의 아규먼트를 선언하면 된다. 

  @PostMapping(value="h1", produces="text/html;charset=UTF-8") 
  @ResponseBody 
  public String handler1(
      PrintWriter out,
      String name,
      int age, 
      MultipartFile photo 
      ) throws Exception {
    
    String filename = null;
    if (!photo.isEmpty()) {
      filename = UUID.randomUUID().toString();
      String path = sc.getRealPath("/html/app1/" + filename);
      photo.transferTo(new File(path));
    }
    
    return "<html><head><title>c04_8/h1</title></head><body>" + 
            "<h1>업로드 결과</h1>" + 
            "<p>이름:" + name + "</p>" +
            "<p>나이:" + age + "</p>" +
            (filename != null ? "<p><img src='../../html/app1/" + filename + "'></p>" : "") +
            "</body></html>";
  }

 

}








