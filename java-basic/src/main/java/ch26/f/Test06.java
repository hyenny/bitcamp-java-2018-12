

// dynamic SQL 다루기 - <trim> 태그 사용 
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test06 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();


    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? ");
    String value = keyboard.nextLine();
    HashMap<String, Object> params = new HashMap<>();
    
    // SQL 문장 앞에 오는 키워드를 제거하기
    // 동적 SQL을 다루다 보면 조건에 따라 다음과 같은 문장이 생성될 수 있다.
    //  where
    //      or title = #{title}
    // 이 때 or 앞에 다른 조건이 없기 때문에 or를 제거해야 한다.
    // 이를 자동으로 처리하려면 <trim> 태그를 사용하라!
    
    try {
      params.put("no", Integer.parseInt(value));
      // 숫자로 바꿀 수 있으면 맵에 "no" 이름으로 값이 저장될 것이고,
      // 숫자로 바꿀 수 없으면 맵에 "no" 이름의 값이 없을 것이다.
    } catch (Exception e) {

    }
    
    System.out.print("제목? ");
    value = keyboard.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }
    
    System.out.print("내용? ");
    value = keyboard.nextLine();
    if (value.length() > 0) {
      params.put("contents", value);
    }
        
    keyboard.close();
  

    List<Board> boards = sqlSession.selectList("board.select6", params);


    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }

}






