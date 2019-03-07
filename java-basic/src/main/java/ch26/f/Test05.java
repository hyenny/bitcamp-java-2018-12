// dynamic SQL 다루기 - <choose> 사용
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();


    // 여러 개의 조건 중 한 개에 대해 
    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? ");
    String value = keyboard.nextLine();
    HashMap<String, Object> params = new HashMap<>();
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
  

    List<Board> boards = sqlSession.selectList("board.select5", params);


    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }

}






