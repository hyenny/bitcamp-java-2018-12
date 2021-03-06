// 연습 - 게시물 등록
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDetailApp {
  public static void main(String[] args) {
    // 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
    // ---------------------------------------
    // 번호? 1
    // 제목 : aaa
    // 내용 : aaaa
    // 등록일 : 2019-1-1
    // 조회수 : 2
    //
    // 번호? 100
    // 해당 번호의 게시물이 존재하지 않습니다.
    //----------------------------------------
    
    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호? ");
    String id = keyboard.nextLine();
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      try (Statement stmt = con.createStatement()) {
        
        try (ResultSet rs = stmt.executeQuery(
            "select * from x_board where board_id =" + id)) {
                            
          if (rs.next()) {
            // 레코드에서 컬럼 값을 꺼낼 때 컬럼 번호를 지정하는 것 보다 
            // 컬럼의 이름을 지정하는 것이 유지보수에 더 좋다.
            //
            System.out.printf("%d, %s, %s, %s, %d\n", 
                rs.getInt("board_id"), 
                rs.getString("title"), 
                rs.getString("contents"), 
                rs.getDate("created_date"),
                rs.getInt("view_count"));
          } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          }
          
        }
        
        
        
      }
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    
    


  }
}
