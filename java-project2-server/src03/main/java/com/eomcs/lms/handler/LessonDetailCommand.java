package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand implements Command {

  LessonDaoImpl lessonDao;

  public LessonDetailCommand(LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();

      int no = Integer.parseInt(in.readLine());

      Lesson lesson = lessonDao.findByNo(no);
      out.printf("수업명: %s\n", lesson.getClassName());
      out.printf("설명: %s\n", lesson.getContents());
      out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
      out.printf("총수업시간: %d\n", lesson.getTotalTime());
      out.printf("일수업시간: %d\n", lesson.getDayTime());

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }

  }
}
