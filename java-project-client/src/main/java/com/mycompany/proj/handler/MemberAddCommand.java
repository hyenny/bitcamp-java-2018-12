package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Member;

public class MemberAddCommand implements Command {

  Scanner keyboard;
  List<Member> list;

  public MemberAddCommand(Scanner keyboard, List<Member> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNum(Integer.parseInt(keyboard.nextLine()));

    System.out.print("이름? ");
    member.setName(keyboard.nextLine());

    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine());

    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());

    System.out.print("사진? ");
    member.setPicture(keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());

    member.setJoinDate(new Date(System.currentTimeMillis())); 

    list.add(member);

    System.out.println("저장하였습니다.");
  }



}
