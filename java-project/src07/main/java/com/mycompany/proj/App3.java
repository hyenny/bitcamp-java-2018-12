
package com.mycompany.proj;

import java.sql.Date;

public class App3 {
    
    public static void main(String[] args) {
      
      int idx = 0;
      int i = 0;
      
      Board[] boards = new Board[100]; 
      
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      while(true) {
        
        boards[idx] = new Board(); 
        boards[idx].writeDate = new Date(System.currentTimeMillis());
        boards[idx].hits = 0;
        
        System.out.print("번호?:");
        boards[idx].num = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("내용?:");
        boards[idx].contents = keyboard.nextLine();
        
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
      System.out.printf("%d, %s, %s, %d\n", boards[i].num, boards[i].contents, boards[i].writeDate, boards[i].hits);
      i++;
    }
      

    }
}
