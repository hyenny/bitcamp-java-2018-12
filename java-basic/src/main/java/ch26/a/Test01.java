// Mybatis 설정하기
// 1). Mybatis 라이브러리 파일을 프로젝트에 등록하기
//      - mvnrepository.com에서 Mybatis 검색하여 라이브러리 정보 알아낸다.
//       - build.gradle 파일에 의존 라이브러리 정보를 추가한다.
//      - 'gradle eclipse' 실행하여 라이브러리를 다운로드 받고, 이클립스 설정 파일에 등록한다.
//      - 이클립스 프로젝트를 리프레시하여 라이브러리 정보를 반영한다.
// 2). Mybatis 설정 파일 준비
//      - mybatis.org 사이트에서 문서 페이지를 참조한다.
//      - mybatis 설정 파일(mybatis-config.xml)을 생성한다.
//      - 문서 페이지를 참조하여 설정 파일의 내용을 변경한다.
// 3). SQL 매퍼 파일 준비
//      - mybatis.org사이트에서 문서 페이지를 참조한다.
//      - SQL이 들어 있는 파일(예: BoardMapper.mxl)을 생성한다.
//
package ch26.a;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {
    String resource = "ch26/a/mybatis-config.xml";
    
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> list = sqlSession.selectList("board.select1");
    
    
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d,\n",
          b.getBoard_id(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
  }

}
