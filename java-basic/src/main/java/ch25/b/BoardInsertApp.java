// 연습 - 게시물 등록
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n)
// 등록하였습니다.
//----------------------------

public class BoardInsertApp {
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("제목? ");
    String title = keyboard.nextLine();

    System.out.print("내용? ");
    String contents = keyboard.nextLine();

    System.out.print("등록하시겠습니까?(Y/n)? ");
    String command = keyboard.nextLine();

    if (!(command.equalsIgnoreCase("y"))) {
      System.out.println("등록을 취소하였습니다.");
      return;
    } 


    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try (Statement stmt = con.createStatement()) {
        String sql = "insert into x_board(title,contents) values(" + "'"+title+"'" + "," + "'"+contents+"')";
        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        System.out.println("등록하였습니다.");
      }

    } catch (Exception e) {
      System.out.println("데이터베이스 접속 오류.");
      e.printStackTrace();
    }
  } //main



}
