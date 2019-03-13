package com.eomcs.lms.handler;
import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public LessonUpdateCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    // SqlSession 객체를 준비한다.
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      // SqlSession으로부터 DAO 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 타입 정보)
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);

      int no = response.requestInt("번호?");

      Lesson lesson = lessonDao.findByNo(no);
      if (lesson == null) {
        response.println("해당 번호의 수업이 없습니다.");
        return;
      }

      // 변경할 값만 temp에 저장할 것이기 때문에 기존 데이터를 복제하지 않는다. 
      Lesson temp = new Lesson();
      temp.setNum(no);

      // mybatis는 필드의 값이 null이 아니거나, 숫자인 경우 0인 아니면 해당 컬럼을 값을 update 한다.
      String input = response.requestString(String.format(
          "수업명(%s)?", lesson.getClassName()));
      if (input.length() > 0)
        temp.setClassName(input);

      input = response.requestString(String.format(
          "설명(%s)?", lesson.getContents()));
      if (input.length() > 0)
        temp.setContents(input);

      input = response.requestString(String.format(
          "시작일(%s)?", lesson.getStartDate()));
      if (input.length() > 0)
        temp.setStartDate(Date.valueOf(input));

      input = response.requestString(String.format(
          "종료일(%s)?", lesson.getEndDate()));
      if (input.length() > 0)
        temp.setEndDate(Date.valueOf(input));

      input = response.requestString(String.format(
          "총수업시간(%d)?", lesson.getTotalTime()));
      if (input.length() > 0)
        temp.setTotalTime(Integer.parseInt(input));

      input = response.requestString(String.format(
          "일수업시간(%d)?", lesson.getDayTime()));
      if (input.length() > 0)
        temp.setDayTime(Integer.parseInt(input));

      if (temp.getClassName() != null
          || temp.getContents() != null
          || temp.getStartDate() != null
          || temp.getEndDate() != null
          || temp.getTotalTime() > 0
          || temp.getDayTime() > 0) {
        
        lessonDao.update(temp);
        response.println("변경했습니다.");
      

      } else {
        response.println("변경 취소했습니다.");
      }
    }
  }
}


//
