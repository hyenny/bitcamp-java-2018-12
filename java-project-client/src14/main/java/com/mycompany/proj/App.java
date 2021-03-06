// 13단계: stateful 방식을 stateless 방식으로 전환하기 
package com.mycompany.proj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.mycompany.proj.handler.BoardAddCommand;
import com.mycompany.proj.handler.BoardDeleteCommand;
import com.mycompany.proj.handler.BoardDetailCommand;
import com.mycompany.proj.handler.BoardListCommand;
import com.mycompany.proj.handler.BoardUpdateCommand;
import com.mycompany.proj.handler.Command;
import com.mycompany.proj.handler.LessonAddCommand;
import com.mycompany.proj.handler.LessonDeleteCommand;
import com.mycompany.proj.handler.LessonDetailCommand;
import com.mycompany.proj.handler.LessonListCommand;
import com.mycompany.proj.handler.LessonUpdateCommand;
import com.mycompany.proj.handler.MemberAddCommand;
import com.mycompany.proj.handler.MemberDeleteCommand;
import com.mycompany.proj.handler.MemberDetailCommand;
import com.mycompany.proj.handler.MemberListCommand;
import com.mycompany.proj.handler.MemberUpdateCommand;
import com.mycompany.proj.proxy.BoardDaoProxy;
import com.mycompany.proj.proxy.LessonDaoProxy;
import com.mycompany.proj.proxy.MemberDaoProxy;


public class App {

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();

  public void service() {

    Map<String,Command> commandMap = new HashMap<>();

    LessonDaoProxy lessonDao = new LessonDaoProxy("localhost", 8888, "/lesson");
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonDao));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonDao));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonDao));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonDao));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonDao));

    MemberDaoProxy memberDao = new MemberDaoProxy("localhost", 8888, "/member");
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberDao));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberDao));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberDao));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberDao));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberDao));

    BoardDaoProxy boardDao = new BoardDaoProxy("localhost", 8888, "/board");
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardDao));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardDao));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardDao));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardDao));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardDao));

    while (true) {
      String command = prompt();
      
      commandHistory.push(command);
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        System.out.println("종료합니다.");
        break;
        
      } else if (command.equals("history")) {
        printCommandHistory();
        continue;
        
      } else if (command.equals("history2")) {
        printCommandHistory2();
        continue;
      } 
      
      // 사용자가 입력한 명령으로 Command 객체를 찾는다.
      Command commandHandler = commandMap.get(command);
      if (commandHandler == null) {
        System.out.println("실행할 수 없는 명령입니다.");
        continue;
      }
      
      // stateful을 stateless로 전환할 때 주의할 점!
      // => 가능한 서버에 요청하는 시점에 서버와 연결하라!
      // => 이 클래스에서 서버와 연결하지 않고 
      //    데이터를 요청하는 일을 하는 객체(*Agent)에 서버 연결을 맡긴다. 
      try {
        commandHandler.execute();
        System.out.println(); 

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }
    }
    
    keyboard.close();
  }
  
  @SuppressWarnings("unchecked")
  private void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  public static void main(String[] args) {
    App app = new App();

    // App 을 실행한다.
    app.service();
  }
}
