// update 실행하기
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test09 {

  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
      System.out.println("DBMS에 연결됨!");
      
      try (Statement stmt = con.createStatement()) {
        try (ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc")) {
          while (rs.next()) {
            System.out.printf("%d, %s, %s, %s, %d\n",
                rs.getInt("board_id"),
                rs.getString("title"),
                rs.getString("contents"),
                rs.getDate("created_date"),
                rs.getInt("view_count"));
          }
        }
      }
      
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
    

    


  }
}
