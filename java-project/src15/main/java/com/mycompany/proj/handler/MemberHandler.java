package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Member;

public class MemberHandler {

  static final int LENTH = 10;

  int m_idx;
  Member[] members = new Member[LENTH]; 
  
  Scanner keyboard;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    
  }

  public void addMember() {
    Member member = new Member();
    member.setJoinDate(new Date(System.currentTimeMillis()));

    System.out.print("번호?:");
    member.setNum(keyboard.nextInt());

    keyboard.nextLine();

    System.out.print("이름?:");
    member.setName(keyboard.nextLine());

    System.out.print("이메일?:");
    member.setEmail(keyboard.nextLine());

    System.out.print("암호?:");
    member.setPassword(keyboard.nextLine());

    System.out.print("사진?:");
    member.setPicture(keyboard.nextLine());

    System.out.print("전화?:");
    member.setTel(keyboard.nextLine());

    members[m_idx] = member;

    m_idx++;
    System.out.print(m_idx);

  }

  public void listMember() {
    int i = 0;
    while(i < m_idx) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          members[i].getNum(), members[i].getName(),
          members[i].getEmail(), members[i].getTel(), members[i].getJoinDate());
      i++;

    }

  }
}
