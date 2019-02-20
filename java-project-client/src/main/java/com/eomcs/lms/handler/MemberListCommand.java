package com.eomcs.lms.handler;


import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberListCommand implements Command {
  
  Scanner keyboard;
  MemberDaoImpl memberAgent;
  
  public MemberListCommand(Scanner keyboard, MemberDaoImpl memberAgent) {
    this.keyboard = keyboard;
    this.memberAgent = memberAgent;
  }
  
  @Override
  public void execute() {
    try {
      List<Member> members = memberAgent.findAll();
      for (Member member : members) {
        System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
            member.getNum(), member.getName(), 
            member.getEmail(), member.getTel(), member.getJoinDate());
      }
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
