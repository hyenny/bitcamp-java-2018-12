package com.eomcs.lms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.service.LessonService;


@Controller
public class LessonDeleteController{

  @Autowired LessonService lessonService;
  
  @RequestMapping("/lesson/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    if (lessonService.delete(no) == 0) {
      throw new Exception("해당 수업의 게시물이 없습니다.");
      
    } 
    return "redirect:list";
  }
}
