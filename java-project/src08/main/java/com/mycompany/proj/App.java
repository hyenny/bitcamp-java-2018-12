
package com.mycompany.proj;

import java.sql.Date;

public class App {

  public static void main(String[] args) {
    int l_idx = 0;
    int m_idx = 0;
    int b_idx = 0;

    Lesson[] lessons = new Lesson[100]; // lessons : Lesson 레퍼런스 배열 생성
    Member[] members = new Member[100]; 
    Board[] boards = new Board[100]; 

    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    while (true) {
      System.out.print("명령>:");
      String command = keyboard.nextLine();

      if (command.equals("/lesson/add") ) {
        // lesson 입력
        Lesson lesson = new Lesson(); 

        System.out.print("번호?:");
        lesson.num = Integer.parseInt(keyboard.nextLine());

        System.out.print("수업명?:");
        lesson.className = keyboard.nextLine();

        System.out.print("수업내용?:");
        lesson.contents = keyboard.nextLine();

        System.out.print("시작일?:");
        lesson.startDate = Date.valueOf(keyboard.nextLine());

        System.out.print("종료일?:");
        lesson.endDate = Date.valueOf(keyboard.nextLine());

        System.out.print("총수업시간?:");
        lesson.totalTime = Integer.parseInt(keyboard.nextLine());

        System.out.print("일수업시간?:");
        lesson.dayTime = Integer.parseInt(keyboard.nextLine());
        
        lessons[l_idx] = lesson;

        l_idx++; 
        System.out.print(l_idx);
        

      } else if(command.equals("/lesson/list")) {
        // lesson 출력
        int i = 0;
        while (i < l_idx) {
          System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
              lessons[i].num,lessons[i].className, lessons[i].startDate, lessons[i].endDate, lessons[i].totalTime);
          i++;
        }

      } else if(command.equals("/member/add")) {
        // member 입력

       Member member = new Member();
        member.joinDate = new Date(System.currentTimeMillis());

        System.out.print("번호?:");
        member.num = keyboard.nextInt();

        keyboard.nextLine();

        System.out.print("이름?:");
        member.name = keyboard.nextLine();

        System.out.print("이메일?:");
        member.email = keyboard.nextLine();

        System.out.print("암호?:");
        member.password = keyboard.nextLine();

        System.out.print("사진?:");
        member.picture = keyboard.nextLine();

        System.out.print("전화?:");
        member.tel = keyboard.nextLine();
        
        members[m_idx] = member;

        m_idx++;
        System.out.print(m_idx);


      } else if (command.equals("/member/list")) {
        // member 출력
        int i = 0;
        while(i < m_idx) {
          System.out.printf("%d, %s, %s, %s, %s\n", 
              members[i].num, members[i].name, members[i].email, members[i].tel, members[i].joinDate);
          i++;
        }

      } else if(command.equals("/board/add")) {
        // board 입력

        Board board = new Board();
        
        board.writeDate = new Date(System.currentTimeMillis());
        board.hits = 0;

        System.out.print("번호?:");
        board.num = Integer.parseInt(keyboard.nextLine());

        System.out.print("내용?:");
        board.contents = keyboard.nextLine();
        
        boards[b_idx] = board;

        b_idx++;

        
      } else if(command.equals("/board/list")) {
        // board 출력
        int i = 0;
        while(i < b_idx) {
          System.out.printf("%d, %s, %s, %d\n", boards[i].num, boards[i].contents, boards[i].writeDate, boards[i].hits);
          i++;
        }

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

}
