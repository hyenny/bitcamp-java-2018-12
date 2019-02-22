package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberListCommand implements Command {
  
  MemberDaoImpl memberAgent;
  
  public MemberListCommand(MemberDaoImpl memberAgent) {
    this.memberAgent = memberAgent;
  }
  
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      List<Member> members = memberAgent.findAll();
      for (Member member : members) {
        out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
            member.getNum(), member.getName(), 
            member.getEmail(), member.getTel(), member.getJoinDate());
      }
    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
