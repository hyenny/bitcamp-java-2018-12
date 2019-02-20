// Statement와 SQL 삽입 공격
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {
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
        
        // SQL 삽입 공격
        // => 입력 문자열에 SQL 명령을 삽입하여 프로그램의 의도와 다르게 데이터를 조작하는 행위
        // => 사용자가 입력한 값을 가지고 SQL 문장을 만들 때 이런 문제가 발생한다. 
        // => 예를 들어 이 예제를 실행할 때 다음과 같이 입력해 보라!
        // 번호? 2
        //제목 : okok
        //내용 : test', view_count = 300, created_date = '2019-3-3
        //
        
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
