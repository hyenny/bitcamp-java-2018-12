package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.domain.Lesson;


public class LessonUpdateCommand implements Command {

  LessonDaoImpl lessonDao;

  public LessonUpdateCommand(LessonDaoImpl lessonDao) {
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

      Lesson temp = lesson.clone();

      out.printf("수업명(%s)? ", lesson.getClassName());
      out.println();
      out.println("!{}!");
      out.flush();
      String input = in.readLine();
      if (input.length() > 0) 
        temp.setClassName(input);

      out.printf("설명(%s)? ", lesson.getContents());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setContents(input);

      out.printf("시작일(%s)? ", lesson.getStartDate());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setStartDate(Date.valueOf(input));

      out.printf("종료일(%s)? ", lesson.getEndDate());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setEndDate(Date.valueOf(input));

      out.printf("총수업시간(%d)? ", lesson.getTotalTime());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setTotalTime(Integer.parseInt(input));

      out.printf("일수업시간(%d)? ", lesson.getDayTime());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setDayTime(Integer.parseInt(input));

      //lessonDao.update(temp);

      if (lessonDao.update(temp) == 0) {
        out.println("해당 수업이 없습니다.");
        return;
      }
      out.println("변경했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
