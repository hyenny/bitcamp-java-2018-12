// dynamic SQL 다루기 - <where> 태그 사용 후 
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    // dynamic sql?
    // => 조건에 따라 SQL이 변경되는 것.
    // => mybatis는 이를 위해 조건문, 반복문 등을 다룰 수 있도록 특별한 태그를 제공한다.

    // 조건문 사용하기
    // => 파라미터 값을 맵 객체에 담아 전달하기
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
  

    List<Board> boards = sqlSession.selectList("board.select4", params);


    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }

}






