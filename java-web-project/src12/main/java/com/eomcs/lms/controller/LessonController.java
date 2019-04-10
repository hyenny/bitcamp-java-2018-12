package com.eomcs.lms.controller;

import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Controller
public class LessonController {
  
  @Autowired LessonService lessonService;
  
  @RequestMapping("/lesson/add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return "/lesson/form.jsp";
    }
    
    Lesson lesson = new Lesson();
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

    lessonService.add(lesson);

    return "redirect:list";

  }
  
  @RequestMapping("/lesson/delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    if (lessonService.delete(no) == 0) {
      throw new Exception("해당 수업의 게시물이 없습니다.");
      
    } 
    return "redirect:list";
  }
  
  @RequestMapping("/lesson/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    
    // JSP가 사용할 수 있도록 ServletRequest 보관소에 저장해둔다.
    request.setAttribute("lesson", lesson);
    
    return "/lesson/detail.jsp";
  }
  
  @RequestMapping("/lesson/list")
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Lesson> lessons = lessonService.list();

    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", lessons);

    return "/lesson/list.jsp";

  }
  
  @RequestMapping("/lesson/update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(request.getParameter("no")));
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
    
    if (lessonService.update(lesson) == 0)
      throw new Exception("해당 수업의 게시물이 없습니다.");
    
    return "redirect:list";
  }
  
  
  
  
  
}