
 
package com.mycompany.proj;

//java.sql.Date와 java.util.Date의 차이?
import java.sql.Date;


//번호? 1
//이름? 홍길동
//이메일? hong@test.com
//암호? 1111
//사진? hong.png
//전화? 1111-2222
//
//번호: 1
//이름: 홍길동
//이메일: hong@test.com
//암호: 1111
//사진: hong.png
//전화: 1111-2222
//가입일: 2019-01-01

public class App2 {
    
    public static void main(String[] args) {
      int num;
      String name, email, password, picture, tel;
      //String joinDate = "2019-01-01";
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      System.out.print("번호?:");
      num = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("이름?:");
      name = keyboard.nextLine();
      
      System.out.print("이메일?:");
      email = keyboard.nextLine();
      
      System.out.print("암호?:");
      password = keyboard.nextLine();
          
      System.out.print("사진?:");
      picture = keyboard.nextLine();
      
      System.out.print("전화?:");
      tel = keyboard.nextLine();
      
      Date joinDate = new Date(System.currentTimeMillis());
      
      System.out.println("");
      
      System.out.printf("번호 : %d\n",num);
      System.out.printf("이름 : %s\n",name);
      System.out.printf("이메일 : %s\n",email);
      System.out.printf("암호 : %s\n", password);
      System.out.printf("사진 : %s\n",picture);
      System.out.printf("전화 : %s\n", tel);
      System.out.printf("가입일 : %s\n",joinDate);
    }
}
