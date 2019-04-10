package com.eomcs.lms.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@Controller("/photoboard/detail")
public class PhotoBoardDetailController implements PageController{

  @Autowired PhotoBoardService photoBoardService;
  @Autowired LessonService lessonService;
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
int no = Integer.parseInt(request.getParameter("no"));

    

    PhotoBoard photoBoard = photoBoardService.get(no);
    List<Lesson> lessons = lessonService.list();
    request.setAttribute("photoBoard", photoBoard);
    request.setAttribute("lessons", lessons);
    request.setAttribute("files", photoBoard.getFiles());
    
    return "/photoboard/detail.jsp";
  }



}