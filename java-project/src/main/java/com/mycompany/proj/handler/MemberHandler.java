package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.App;
import com.mycompany.proj.domain.Member;

public class MemberHandler {
  
  static int m_idx = 0;
  static Member[] members = new Member[App.NUMBER];

  public static void addMember() {
    Member member = new Member();
    Scanner keyboard = App.keyboard;
   
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
  }

  public static void listMember() {
    // member 출력
    int i = 0;
    while(i < m_idx) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          members[i].num, members[i].name, members[i].email, members[i].tel, members[i].joinDate);
      i++;
    }
  }



}


