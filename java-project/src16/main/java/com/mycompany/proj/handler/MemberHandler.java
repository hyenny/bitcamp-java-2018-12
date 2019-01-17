package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Member;

public class MemberHandler {
  
  Scanner keyboard;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard; 
  }
  
  MemberList memberList = new MemberList();

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

    memberList.add(member);
    
    System.out.println("저장하였습니다");


  }

  public void listMember() {
    int i = 0;
    while(i < memberList.toArray().length) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          memberList.toArray()[i].getNum(), memberList.toArray()[i].getName(),
          memberList.toArray()[i].getEmail(), memberList.toArray()[i].getTel(), memberList.toArray()[i].getJoinDate());
      i++;

    }

  }
}
