package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    ApplicationContext ionContainer = (ApplicationContext) sc.getAttribute("iocContainer");
    // Spring IoC 컨테이너에서 LessonService 객체를 꺼낸다.
    LessonService lessonService = ionContainer.getBean(LessonService.class);
    
    List<Lesson> lessons = lessonService.list();
    
    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", lessons);

    response.setContentType("text/html;charset=UTF-8");
    
    // JSP의 실행을 포함시킨다.
    RequestDispatcher rd = request.getRequestDispatcher("/lesson/list.jsp");
    rd.include(request, response);
   

  }
}