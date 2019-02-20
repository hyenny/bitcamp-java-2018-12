// DBMS에 연결하기 - java.sql.Driver 구현체 조
package ch25.a;

import java.sql.DriverManager;

public class Test04 {

  public static void main(String[] args) {

    // DriverManager의 getConnection()을 호출할 때
    // DrieverJManager는 jdbcURL 정보를 바탕으로 'java.sql.Driver' 구현체를 갖는다.
    // => 즉 개발자가 코드로 jva.sql.Driver 구현체를 직접 등록하지 않아도,
    //      또는 java.sql.Driver를 구현한 클래스를 로딩하지 않아도
    //      자동 로그인한다.
    //  어덯게회
    try {
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
    } catch (Exception e) {
      e.printStackTrace();

    }

  }
}
