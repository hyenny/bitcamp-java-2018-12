package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Member;
import com.mycompany.util.ArrayList;

public class MemberHandler {

  Scanner keyboard;

  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard; 
  }

  ArrayList memberList = new ArrayList();

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
    Object[] objs = memberList.toArray();
    for(Object obj : objs) {
      Member member = (Member) obj;
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNum(), member.getName(),
          member.getEmail(), member.getTel(), member.getJoinDate());
    }


  }

}

