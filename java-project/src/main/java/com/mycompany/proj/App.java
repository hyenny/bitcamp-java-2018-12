
package com.mycompany.proj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
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

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비(Stack, Queue)
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();
  
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static ArrayList<Member> memberList = new ArrayList<>();
  static ArrayList<Board> boardList = new ArrayList<>();

  public static void main(String[] args) {
    loadLessonData();
    loadMemberData();
    loadBoardData();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));


    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        quit();
        break;

      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>(){
          int index = commandHistory.size() -1;

          @Override
          public boolean hasNext() {
            // TODO Auto-generated method stub
            return index >= 0;
          }

          @Override
          public String next() {
            return commandHistory.get(index--);
          }

        });

      } else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());

      } else {
        Command commandHandler = commandMap.get(command);

        if (commandHandler == null) {
          System.out.println("실행할 수 없는 명령입니다.");
        } else
          try {
            commandHandler.execute();
          } catch (Exception e) {
            System.out.printf("작업 중 오류 발생: %s\n", e.toString());
          }
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    try {

      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next() + ",");
        if (++count % 5 == 0) {
          System.out.print(":");
          String input = keyboard.nextLine();
          if (input.equalsIgnoreCase("q"))
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
  
  private static void quit() {
    saveLessonData();
    saveMemberData();
    saveBoardData();
    System.out.println("안녕!");
  }
  
  private static void loadLessonData() {
    try (FileReader in = new FileReader("lesson.csv");
        Scanner in2 = new Scanner(in);
        ) {
      while (true) {
        // 번호,제목,내용,시작일,종료일,총강의시간,일강의시간
        lessonList.add(Lesson.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NoSuchElementException e) {
      System.out.println("수업 데이터 로딩 완료");
    }
  }
  
  private static void saveLessonData() {
    try (FileWriter out = new FileWriter("lesson.csv");) {
      for (Lesson lesson : lessonList) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n", //공백이 있으면 안된다.
            lesson.getNum(),
            lesson.getClassName(),
            lesson.getContents(),
            lesson.getStartDate(),
            lesson.getEndDate(),
            lesson.getTotalTime(),
            lesson.getDayTime()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private static void loadMemberData() {
    try (FileReader in = new FileReader("member.csv");
        Scanner in2 = new Scanner(in);
        ) {
      while (true) {
        // 번호,이름,이메일,패스워드,사진,전화번호,가입일
        memberList.add(Member.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NoSuchElementException e) {
      System.out.println("회원 데이터 로딩 완료");
    }
  }
  
  private static void saveMemberData() {
    try (FileWriter out = new FileWriter("member.csv");) {
      for (Member member : memberList) {
        out.write(String.format("%s,%s,%s,%s,%s,%s,%s\n", //공백이 있으면 안된다.
            member.getNum(),
            member.getName(),
            member.getEmail(),
            member.getPassword(),
            member.getPicture(),
            member.getTel(),
            member.getJoinDate()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private static void loadBoardData() {
    try (FileReader in = new FileReader("board.csv");
        Scanner in2 = new Scanner(in);
        ) {
      while (true) {
        // 번호,내용,조회수,작성일
        boardList.add(Board.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NoSuchElementException e) {
      System.out.println("게시판 데이터 로딩 완료");
    }
  }
  
  private static void saveBoardData() {
    try (FileWriter out = new FileWriter("board.csv");) {
      for (Board board : boardList) {
        out.write(String.format("%s,%s,%s,%s\n", //공백이 있으면 안된다.
            board.getNum(),
            board.getContents(),
            board.getHits(),
            board.getWriteDate()));
      
  
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  
  
  
  
}

