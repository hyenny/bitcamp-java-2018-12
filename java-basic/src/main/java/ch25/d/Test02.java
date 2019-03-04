// insert 한 후 auto increment PK 값 리턴 받기 
package ch25.d;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02 {

  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      con.setAutoCommit(false);

      // 2). 데이터의 변경 작업을 수행 - 여러 개의 insert, update, delete 수행
      for (int i = 0; i < 3; i++) {
        try (PreparedStatement stmt = con.prepareStatement(
            "insert into x_board(title, contents) values(?,?)")) {

          stmt.setString(1, "aaa");
          stmt.setString(2, "bbb");
          stmt.executeUpdate();
          System.out.println("입력 성공!");
        }
      }
      
      // 3) 트랜잭션을 종료 = 서버의 요청한 작업을 처리할 것을 명령한다.
      // => commit()을 호출하지 아넣으면 서버에 요청한 데이터 변경 작업은 자동 취소된다.
      con.commit();
      
      // 주의!
      // => 트랜잭션은 커넥션 단위로 관리된다.
      // => 즉 같은 커넥션을 사용하면 서로 영향을 끼치게 된다. 

    } catch (Exception e) {
      e.printStackTrace();
    }



  }

}











