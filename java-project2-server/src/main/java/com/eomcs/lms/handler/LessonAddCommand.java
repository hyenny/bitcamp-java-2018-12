package com.eomcs.lms.handler;

import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.domain.Lesson;


public class LessonAddCommand extends AbstractCommand {

  LessonDaoImpl lessonDao;

  public LessonAddCommand(LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(Response response) throws Exception {
      Lesson lesson = new Lesson();

      lesson.setClassName(response.requestString("수업명?"));
      lesson.setContents(response.requestString("설명?"));
      lesson.setStartDate(response.requestDate("시작일?"));
      lesson.setEndDate(response.requestDate("종료일?"));
      lesson.setTotalTime(response.requestInt("총수업시간?"));
      lesson.setDayTime(response.requestInt("일수업시간?"));

      lessonDao.insert(lesson);
      response.println("저장하였습니다.");

  }

}
