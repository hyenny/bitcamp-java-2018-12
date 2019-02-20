// 연습 - 게시물 등록
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardUpdateApp {
  public static void main(String[] args) {
    // 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
    // ---------------------------------------
    // 번호? 1
    // 제목 : xxx
    // 내용 : xxxxxx
    // 변경하였습니다.
    // (또는)
    // 해당 번호의 게시물이 존재하지 않습니다.
    // ---------------------------------------
    
    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호? ");
    String id = keyboard.nextLine();
    
    System.out.print("제목 : ");
    String title = keyboard.nextLine();
    
    System.out.print("내용 : ");
    String contents = keyboard.nextLine();
    
    
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
      
      try (Statement stmt = con.createStatement()) {
        String sql = "update x_board set title = '" + title + "'," + "contents = '" + contents + "' where board_id = " + id;
        
        int count = stmt.executeUpdate(sql);
        
        if (count == 0)
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        else
          System.out.println("변경하였습니다.");
        
      }

    } catch (Exception e) {
      System.out.print("해당 번호의 게시물이 존재하지 않습니다.");
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }


  }
}
