// DBMS에 연결하기 - java.sql.Driver 구현체 자동 등록
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test03 {
  
  public static void main(String[] args) {
    
   // DriverManager의 getConnection()을 호출할 때
    // DrieverJManager는 jdbcURL 정보를 바탕으로 'java.sql.Driver' 구현체를 갖는다.
    // => 즉 개발자가 코드로 jva.sql.Driver 구현체를 직접 등록하지 않아도,
    //      또는 java.sql.Driver를 구현한 클래스를 로딩하지 않아도
    //      자동 로그인한다.
    //  어덯게
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
      System.out.println("DBMS에 연결 성공!");
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
    
  }
 

}
