package com.eomcs.lms.handler;


import java.sql.Date;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.domain.Lesson;


public class LessonUpdateCommand extends AbstractCommand {

  LessonDaoImpl lessonDao;

  public LessonUpdateCommand(LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(Response response) throws Exception {

    int no = Integer.parseInt(response.requestString("번호?"));

    Lesson lesson = lessonDao.findByNo(no);
    Lesson temp = lesson.clone();


    String input = response.requestString(String.format("수업명(%s)? ", lesson.getClassName()));
    if (input.length() > 0) 
      temp.setClassName(input);


    if ((input = response.requestString(String.format("설명(%s)? ",
        lesson.getContents()))).length() > 0)
      temp.setContents(input);


    if ((input = response.requestString(String.format("시작일(%s)? ",
        lesson.getStartDate()))).length() > 0)
      temp.setStartDate(Date.valueOf(input));

    if ((input = response.requestString(String.format("종료일(%s)? ",
        lesson.getEndDate()))).length() > 0)
      temp.setEndDate(Date.valueOf(input));


    if ((input = response.requestString(String.format("총수업시간(%d)? ",
        lesson.getTotalTime()))).length() > 0)
      temp.setTotalTime(Integer.parseInt(input));


    if ((input = response.requestString(String.format("일수업시간(%d)? ",
        lesson.getDayTime()))).length() > 0)
      temp.setDayTime(Integer.parseInt(input));


    if (lessonDao.update(temp) == 0) {
      response.println("해당 수업이 없습니다.");
      return;
    }
    response.println("변경했습니다.");

  }
}
