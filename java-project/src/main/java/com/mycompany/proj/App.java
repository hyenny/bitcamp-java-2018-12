
package com.mycompany.proj;

import java.sql.Date;

public class App {
  
    public static void main(String[] args) {
      int idx = 0;
      int i = 0;
      int[] num = new int[100];
      String[] className = new String[100];
      String[] contents = new String[100];
      Date[] startDate = new Date[100];
      Date[] endDate = new Date[100];
      int[] totalTime = new int[100]; 
      int[] dayTime = new int[100];
      
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      while(true) {
        
        System.out.print("번호?:");
        num[idx] = keyboard.nextInt();
        
        keyboard.nextLine();
        
        System.out.print("수업명?:");
        className[idx] = keyboard.nextLine();
        
        System.out.print("수업내용?:");
        contents[idx] = keyboard.nextLine();
        
        System.out.print("시작일?:");
        startDate[idx] = Date.valueOf(keyboard.nextLine());
        
        System.out.print("종료일?:");
        endDate[idx] = Date.valueOf(keyboard.nextLine());
        
        System.out.print("총수업시간?:");
        totalTime[idx] = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("일수업시간?:");
        dayTime[idx] = Integer.parseInt(keyboard.nextLine());
        
        System.out.println();
        
        System.out.print("계속 하시겠습니까?(Y/n):");
        String str = keyboard.nextLine();
        System.out.println();
        
        idx++; 
        
        // equals() : 대소문자 구분한다.
        // equalsIgnoreCase() : 대소문자 관계 없이(ignore case) equals 검사를 한다.
        if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase(""))
          break;

        
      }
      
      keyboard.close(); // 스캐너 자원 해제
      
      System.out.println("-------------------------------------------");
      
//      1, 자바 프로젝트 실습     , 2019-01-02 ~ 2019-05-28, 1000
//      2, 자바 프로그래밍 기초    , 2019-02-01 ~ 2019-02-28,  160
//      3, 자바 프로그래밍 고급    , 2019-03-02 ~ 2019-03-30,  160
      
      while(i < idx) {
        System.out.printf("%d, %-20s, %s ~ %s, %d\n", num[i],className[i], startDate[i], endDate[i], totalTime[i]);
        i++;
      }
      
      // %-20s : 20자의 문자열을 왼쪽 정렬(-)한다.
    

    }
     
}
