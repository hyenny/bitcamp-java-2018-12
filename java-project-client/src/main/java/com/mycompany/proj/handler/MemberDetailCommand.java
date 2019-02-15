package com.mycompany.proj.handler;


import java.util.Scanner;
import com.mycompany.proj.agent.MemberAgent;
import com.mycompany.proj.domain.Member;


public class MemberDetailCommand implements Command {
  
  Scanner keyboard;
  MemberAgent memberAgent;
  
  public MemberDetailCommand(Scanner keyboard, MemberAgent memberAgent) {
    this.keyboard = keyboard;
    this.memberAgent = memberAgent;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Member member = memberAgent.get(no);
      System.out.printf("이름: %s\n", member.getName());
      System.out.printf("이메일: %s\n", member.getEmail());
      System.out.printf("암호: %s\n", member.getPassword());
      System.out.printf("사진: %s\n", member.getPicture());
      System.out.printf("전화: %s\n", member.getTel());
      System.out.printf("가입일: %s\n", member.getJoinDate());
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }

  }
}
