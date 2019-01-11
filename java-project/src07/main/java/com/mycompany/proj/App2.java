
 
package com.mycompany.proj;

import java.sql.Date;

public class App2 {
    
    public static void main(String[] args) {
      int idx = 0;
      int i = 0;
      
      Member[] members = new Member[100]; 
      
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      while (true) {
        
        members[idx] = new Member(); 
        members[idx].joinDate = new Date(System.currentTimeMillis());
        
        System.out.print("번호?:");
        members[idx].num = keyboard.nextInt();
        
        keyboard.nextLine();
        
        System.out.print("이름?:");
        members[idx].name = keyboard.nextLine();
        
        System.out.print("이메일?:");
        members[idx].email = keyboard.nextLine();
        
        System.out.print("암호?:");
        members[idx].password = keyboard.nextLine();
            
        System.out.print("사진?:");
        members[idx].picture = keyboard.nextLine();
        
        System.out.print("전화?:");
        members[idx].tel = keyboard.nextLine();
        
        System.out.print("계속 하시겠습니까?(Y/n):");
        String str = keyboard.nextLine();
        
        if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase(""))
          break;
        
        idx++;
        
      }
      
      System.out.println("-------------------------------------------");
      
      while(i <= idx) {
        System.out.printf("%d, %s, %s, %s, %s\n", 
            members[i].num, members[i].name, members[i].email, members[i].tel, members[i].joinDate);
        i++;
      }
      
      
      //번호,이름,이메일,전화,가입일
      
//      1, 홍길동 , hong@test.com       , 1111-2222      , 2019-01-01
//      2, 임꺽정 , lim@test.com        , 1111-2223      , 2019-01-01
//      3, 전봉준 , jeon@test.com       , 1111-2224      , 2019-01-01
      

    }
}
