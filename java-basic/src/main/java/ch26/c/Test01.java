// Mybatis 설정하기 3
// => 도메인 클래스의 별명을 부여하기
// => SQL 매퍼 파일에서 데이터를 리턴하거나 파라미터로 데이터를 받을 때
//      클래스의 전체 이름(패키지 이름을 포함)을 지정해야 한다.
// => 패키지 이름이 길 경우 사용하기가 어렵다.
package ch26.c;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/c/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> list = sqlSession.selectList("board.select1");
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", 
          b.getBoard_id(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
  }

}






