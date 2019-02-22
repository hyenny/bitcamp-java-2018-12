package com.eomcs.lms.handler;



import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;


public class LessonDeleteCommand implements Command {

  LessonDaoImpl lessonDao;

  public LessonDeleteCommand( LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();
      int no = Integer.parseInt(in.readLine());


      lessonDao.delete(no);
      out.println("삭제했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
