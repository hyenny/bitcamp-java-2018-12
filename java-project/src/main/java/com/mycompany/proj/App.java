
package com.mycompany.proj;

import java.util.Scanner;
import com.mycompany.proj.handler.BoardHandler;
import com.mycompany.proj.handler.LessonHandler;
import com.mycompany.proj.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    LessonHandler l1 = new LessonHandler(keyboard);
    MemberHandler m1 = new MemberHandler(keyboard);
    BoardHandler b1 = new BoardHandler(keyboard);
    BoardHandler b2 = new BoardHandler(keyboard);


    while (true) {

      String command = prompt();

      if (command.equals("/lesson/add") ) {
        l1.addLesson();

      } else if(command.equals("/lesson/list")) {
        l1.listLesson();

      } else if(command.equals("/lesson/detail")) {
        l1.detailLesson();

      } else if(command.equals("/lesson/update")) {
        l1.updateLesson();

      } else if(command.equals("/lesson/delete")) {
        l1.deleteLesson();
        
      } else if(command.equals("/member/add")) {
        m1.addMember();

      } else if (command.equals("/member/list")) {
        m1.listMember();

      } else if(command.equals("/board/add")) {
        b1.addBoard();
        
      } else if(command.equals("/board/list")) {
        b1.listBoard();

      } else if(command.equals("/board2/add")) {
        b2.addBoard();

      } else if(command.equals("/board2/list")) {

        b2.listBoard();

      } else if (command.equalsIgnoreCase("quit")) {
        // 나가기
        System.out.println("안녕!");
        break;
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }


    }

    keyboard.close(); // 스캐너 자원 해제


  }

  private static String prompt() {
    System.out.print(("명령> "));
    return keyboard.nextLine();
  }




}
