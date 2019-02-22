package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.domain.Lesson;


public class LessonAddCommand implements Command {

  LessonDaoImpl lessonDao;

  public LessonAddCommand(LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      Lesson lesson = new Lesson();


      out.println("수업명? ");
      out.println("!{}!");
      out.flush();
      lesson.setClassName(in.readLine());

      out.println("설명? ");
      out.println("!{}!");
      out.flush();
      lesson.setContents(in.readLine());

      out.println("시작일? ");
      out.println("!{}!");
      out.flush();
      lesson.setStartDate(Date.valueOf(in.readLine()));

      out.println("종료일? ");
      out.println("!{}!");
      out.flush();
      lesson.setEndDate(Date.valueOf(in.readLine()));

      out.println("총수업시간? ");
      out.println("!{}!");
      out.flush();
      lesson.setTotalTime(Integer.parseInt(in.readLine()));

      out.println("일수업시간? ");
      out.println("!{}!");
      out.flush();
      lesson.setDayTime(Integer.parseInt(in.readLine()));


      lessonDao.insert(lesson);
      out.println("저장하였습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }

}
