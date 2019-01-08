
package com.mycompany.proj;

import java.sql.Date;

public class App3 {
    
    public static void main(String[] args) {
      
      int idx = 0;
      int i = 0;
      int[] num = new int[100];
      String[] contents = new String[100];
      int[] hits = new int[100];
      Date writeDate = new Date(System.currentTimeMillis());
      
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      while(true) {
        System.out.print("번호?:");
        num[idx] = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("내용?:");
        contents[idx] = keyboard.nextLine();
        
        System.out.print("계속 하시겠습니까?(Y/n):");
        String str = keyboard.nextLine();
        
        if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase(""))
          break;
        
        idx++;
        
      }
      
      System.out.println("-------------------------------------------");
      
      //번호,내용,작성일,조회수
//      1, 게시글입니다.              , 2019-01-01, 0
//      2, 두 번째 게시글입니다.        , 2019-01-01, 0
//      3, 세 번째 게시글입니다.        , 2019-01-01, 0
      
    while(i <= idx) {
      System.out.printf("%d, %s, %s, %d\n", num[i],contents[i], writeDate, hits[i]);
      i++;
    }
      

    }
}
