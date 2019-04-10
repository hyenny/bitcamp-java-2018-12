package com.eomcs.lms.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Controller
public class LessonListController {

  @Autowired LessonService lessonService;

  @RequestMapping("/lesson/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Lesson> lessons = lessonService.list();

    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", lessons);

    return "/lesson/list.jsp";

  }
}