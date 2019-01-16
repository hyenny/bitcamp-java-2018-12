
package com.mycompany.proj;

import java.util.Scanner;
import com.mycompany.proj.domain.Board;
import com.mycompany.proj.domain.Lesson;
import com.mycompany.proj.domain.Member;
import com.mycompany.proj.handler.BoardHandler;
import com.mycompany.proj.handler.LessonHandler;
import com.mycompany.proj.handler.MemberHandler;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;

    while (true) {
     
      String command = prompt();

      if (command.equals("/lesson/add") ) {

        LessonHandler.addLesson();
        

      } else if(command.equals("/lesson/list")) {
        // lesson 출력
        LessonHandler.listLesson();

      } else if(command.equals("/member/add")) {
        // member 입력

        MemberHandler.addMember();


      } else if (command.equals("/member/list")) {
        // member 출력
        MemberHandler.listMember();

      } else if(command.equals("/board/add")) {
        // board 입력

        BoardHandler.addBoard();


      } else if(command.equals("/board/list")) {
        // board 출력

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
  
  private static String prompt() {
    System.out.print(("명령> "));
    return keyboard.nextLine();
  }




}
