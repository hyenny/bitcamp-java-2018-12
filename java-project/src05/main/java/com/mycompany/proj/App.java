
package com.mycompany.proj;

//작업1) 한 개의 수업 내용을 입력 받아 출력하라.
//App.java 실행 결과
//
//번호? 1
//수업명? 자바 프로젝트 실습
//수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
//시작일? 2019-01-02
//종료일? 2019-05-28
//총수업시간? 1000
//일수업시간? 8
//
//번호: 1
//수업명: 자바 프로젝트 실습
//수업내용: 자바 프로젝트를 통한 자바 언어 활용법 익히기
//기간: 2019-01-02 ~ 2019-05-28
//총수업시간: 1000 시간
//일수업시간: 8 시간

public class App {
  
    public static void main(String[] args) {
      int num;
      String className, contents, startDate, endDate;
      int totalTime, dayTime;
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      System.out.print("번호?:");
      num = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("수업명?:");
      className = keyboard.nextLine();
      
      System.out.print("수업내용?:");
      contents = keyboard.nextLine();
      
      System.out.print("시작일?:");
      startDate = keyboard.nextLine();
      
          
      System.out.print("종료일?:");
      endDate = keyboard.nextLine();
      
      System.out.print("총수업시간?:");
      totalTime = keyboard.nextInt();
      
      System.out.print("일수업시간?:");
      dayTime = keyboard.nextInt();
      
      System.out.println("");
      
      // 사용 후 스캐너 객체의 자원을 해제한다.
      keyboard.close(); //운영체제 자원(System.***)
      
      //서버 프로그램에서는 자원을 사용하고 난 후, (운영체제(입출력 스트림), 네트워크, DB 등) 닫아줘야 한다. 

      
      System.out.printf("번호 : %d\n",num);
      System.out.printf("수업명 : %s\n",className);
      System.out.printf("수업내용 : %s\n",contents);
      System.out.printf("기간 : %s ~ %s\n", startDate, endDate);
      System.out.printf("총수업시간 : %d 시간\n",totalTime);
      System.out.printf("총수업시간 : %d 시간\n",dayTime);
      
      
    }
        
}
