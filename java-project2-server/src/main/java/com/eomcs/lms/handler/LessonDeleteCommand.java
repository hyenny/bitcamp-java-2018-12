package com.eomcs.lms.handler;



import com.eomcs.lms.dao.mariadb.LessonDaoImpl;


public class LessonDeleteCommand extends AbstractCommand {

  LessonDaoImpl lessonDao;

  public LessonDeleteCommand( LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(Response response) throws Exception {
    int no = Integer.parseInt(response.requestString("번호?"));


    lessonDao.delete(no);
    response.println("삭제했습니다.");
  }
}
