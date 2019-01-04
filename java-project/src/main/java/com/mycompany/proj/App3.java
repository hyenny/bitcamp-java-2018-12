
 
package com.mycompany.proj;

//번호? 1
//내용? 게시글입니다.
//
//번호: 1
//내용: 게시글입니다.
//작성일: 2019-01-01
//조회수: 0

public class App3 {
    
    public static void main(String[] args) {
      int num;
      String contents;
      String writeDate = "2019-01-01";
      int hits = 0;
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      System.out.print("번호?:");
      num = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("내용?:");
      contents = keyboard.nextLine();
      
     
      System.out.println("");
      
      System.out.printf("번호 : %d\n",num);
      System.out.printf("내용 : %s\n",contents);
      System.out.printf("작성일 : %s\n",writeDate);
      System.out.printf("조회수 : %s\n", hits);
      
    }
}
