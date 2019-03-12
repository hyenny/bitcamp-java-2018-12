package com.eomcs.lms.handler;


import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand extends AbstractCommand {

  LessonDao lessonDao;

  public LessonDetailCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(Response response) throws Exception {

      int no = Integer.parseInt(response.requestString("번호?"));

      Lesson lesson = lessonDao.findByNo(no);
      response.println(String.format("수업명: %s", lesson.getClassName()));
      response.println(String.format("설명: %s", lesson.getContents()));
      response.println(String.format("기간: %s ~ %s", lesson.getStartDate(), lesson.getEndDate()));
      response.println(String.format("총수업시간: %d", lesson.getTotalTime()));
      response.println(String.format("일수업시간: %d", lesson.getDayTime()));

  }
}
