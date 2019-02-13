
package com.mycompany.proj;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.mycompany.proj.domain.Board;
import com.mycompany.proj.domain.Lesson;
import com.mycompany.proj.domain.Member;
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
import com.mycompany.proj.listener.BoardDataLoadListener;
import com.mycompany.proj.listener.LessonDataLoadListener;
import com.mycompany.proj.listener.MemberDataLoadListener;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<String>();
  static LinkedList<String> commandHistory2 = new LinkedList<String>();
 

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    Map<String, Command> commandMap = new HashMap<>();


    /*
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    LinkedList<Member> memberList = (LinkedList<Member>) context.get("memberList");
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

     */

    commandMap.put("/board/add", new BoardAddCommand(keyboard));
    commandMap.put("/board/list", new BoardListCommand(keyboard));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard));

    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      
      System.out.println("서버와 연결되었음.");

      while (true) {
        String command = prompt();

        // 사용자가 입력한 명령을 스택에 보관한다.
        commandHistory.push(command);

        // 사용자가 입력한 명령을 큐에 보관한다.
        commandHistory2.offer(command);

        // 사용자가 입력한 명령으로 Command 객체를 찾는다.
        Command commandHandler = commandMap.get(command);

        if (commandHandler != null) {
          try {
            commandHandler.execute(in, out);
          } catch (Exception e) {
            System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
          }
        } else if (command.equals("quit")) {
          quit(in, out);
          break;

        } else if (command.equals("history")) {
          printCommandHistory();

        } else if (command.equals("history2")) {
          printCommandHistory2();

        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }

        System.out.println();
      } //while
    } catch (Exception e) {
      e.printStackTrace();
    }

    keyboard.close();

   
  }
  
  private void quit(ObjectInputStream in, ObjectOutputStream out) {
    try {
      out.writeUTF("quit");
      out.flush();
      System.out.println("서버 =>" + in.readUTF());
      
    } catch (Exception e) {
      // 서버와 연결을 끊다가 오류가 발생하더라도 무시한다.
    }
    
    System.out.println("안녕!");
    
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {
    Stack<String> commandHistory = (Stack<String>) context.get("commandHistory");
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {
    Queue<String> commandHistory2 = (Queue<String>) context.get("commandHistory2");
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    Scanner keyboard = (Scanner) context.get("keyboard");
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

}


