
package com.mycompany.proj;

import java.util.Scanner;

public class App {
  
  final static int NUMBER = 10;

  static Lesson[] lessons = new Lesson[NUMBER];
  static Member[] members = new Member[NUMBER]; 
  static Board[] boards = new Board[NUMBER]; 

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {


    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add") ) {

        LessonHandler.addLesson();

      } else if(command.equals("/lesson/list")) {

        LessonHandler.listLesson();

      } else if(command.equals("/member/add")) {

        MemberHandler.addMember();

      } else if(command.equals("/member/list")) {

        MemberHandler.listMember();

      } else if(command.equals("/board/add")) {

        BoardHandler.addBoard();

      } else if(command.equals("/board/list")) {

        BoardHandler.listBoard();

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

  static String prompt() {
    System.out.print(("명령> "));
    return keyboard.nextLine();
  }

}
