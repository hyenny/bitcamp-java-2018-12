package com.mycompany.proj.handler;

import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Member;

public class MemberListCommand implements Command {

  Scanner keyboard;
  List<Member> list;

  public MemberListCommand(Scanner keyboard, List<Member> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    Member[] members = list.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNum(), member.getName(), 
          member.getEmail(), member.getTel(), member.getJoinDate());


    }

  }
}
