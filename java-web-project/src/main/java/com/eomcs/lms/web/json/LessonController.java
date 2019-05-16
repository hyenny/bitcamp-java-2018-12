package com.eomcs.lms.web.json;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@RestController("json/LessonController")
@RequestMapping("/json/lesson")
public class LessonController {
  
  @Autowired LessonService lessonService;

  
  @PostMapping("add")
  public Object add(Lesson lesson) {
    HashMap<String,Object> content = new HashMap<>();
    try {
      lessonService.add(lesson);
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status","fail");
      content.put("message", e.getMessage());
    }
    
    return content;
  }
  
  @GetMapping("delete")
  public Object delete(int no) {
    HashMap<String,Object> content = new HashMap<>();
    
    try {
      if (lessonService.delete(no) == 0)
        throw new Exception("해당 번호의 수업이 없습니다.");
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }

    return content;
  }
  
  @GetMapping("detail")
  public Object detail(int no) {

    Lesson lesson = lessonService.get(no);
    
    return lesson;
  }

  @GetMapping("list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="3") int pageSize,
      String keyword) {
    
    System.out.printf("컨트롤러 : %d %d %s\n", pageNo, pageSize, keyword);
    
    int rowCount;
    
    if (pageSize < 3 || pageSize > 8) 
      pageSize = 3;
    
    if (keyword != "") {
      rowCount = lessonService.size(keyword);
      System.out.println("검색한 키워드 개수 : " + rowCount);
    } else {
      rowCount = lessonService.size(null);
      System.out.println("전체 열 개수: " + rowCount);
    }
    
    System.out.println(rowCount);
    
    
    int totalPage = rowCount / pageSize;
    if (rowCount % pageSize > 0)
      totalPage++;
    
    if (pageNo < 1) 
      pageNo = 1;
    else if (pageNo > totalPage)
      pageNo = totalPage;
    
      
    List<Lesson> lessons = lessonService.list(pageNo, pageSize, keyword);
    
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", lessons);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);
    content.put("keyword", keyword);
    
    return content;
  }
  
  @PostMapping("update")
  public Object update(Lesson lesson) {
    
    
    HashMap<String,Object> content = new HashMap<>();
    try {
      if (lessonService.update(lesson) == 0)
        throw new Exception("해당 번호의 수업이 없습니다.");
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
      
    }
    
    return content;
  }
}