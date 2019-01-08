
 
package com.mycompany.proj;

import java.sql.Date;

public class App2 {
    
    public static void main(String[] args) {
      int idx = 0;
      int i = 0;
      int[] num = new int[100];
      String[] name = new String[100];
      String[] email = new String[100];
      String[] password = new String[100];
      String[] picture = new String[100];
      String[] tel = new String[100];
      
      Date joinDate = new Date(System.currentTimeMillis());
      
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      while (true) {
        
        System.out.print("번호?:");
        num[idx] = keyboard.nextInt();
        
        keyboard.nextLine();
        
        System.out.print("이름?:");
        name[idx] = keyboard.nextLine();
        
        System.out.print("이메일?:");
        email[idx] = keyboard.nextLine();
        
        System.out.print("암호?:");
        password[idx] = keyboard.nextLine();
            
        System.out.print("사진?:");
        picture[idx] = keyboard.nextLine();
        
        System.out.print("전화?:");
        tel[idx] = keyboard.nextLine();
        
        System.out.print("계속 하시겠습니까?(Y/n):");
        String str = keyboard.nextLine();
        
        if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase(""))
          break;
        
        idx++;
        
      }
      
      System.out.println("-------------------------------------------");
      
      while(i <= idx) {
        System.out.printf("%d, %s, %s, %s, %s\n", num[i], name[i], email[i], tel[i], joinDate);
        i++;
      }
      
      
      //번호,이름,이메일,전화,가입일
      
//      1, 홍길동 , hong@test.com       , 1111-2222      , 2019-01-01
//      2, 임꺽정 , lim@test.com        , 1111-2223      , 2019-01-01
//      3, 전봉준 , jeon@test.com       , 1111-2224      , 2019-01-01
      

    }
}
