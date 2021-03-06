package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/delete")
public class LessonDeleteServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    ApplicationContext ionContainer = (ApplicationContext) sc.getAttribute("iocContainer");
    // Spring IoC 컨테이너에서 LessonService 객체를 꺼낸다.
    LessonService lessonService = ionContainer.getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    if (lessonService.delete(no) > 0) {
      response.sendRedirect("list");
      return;
    }
    
    // 오류 내용을 출력하는 JSP로 포워딩한다.
    request.setAttribute("error.title", "수업 삭제");
    request.setAttribute("error.content", "해당 수업의 게시물이 없습니다.");
    
    request.getRequestDispatcher("/error.jsp").forward(request, response);
    
  }


}
