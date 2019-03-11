package com.eomcs.lms.handler;


import java.util.List;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberListCommand extends AbstractCommand {
  
  MemberDaoImpl memberAgent;
  
  public MemberListCommand(MemberDaoImpl memberAgent) {
    this.memberAgent = memberAgent;
  }
  
  @Override
  public void execute(Response response) throws Exception {
      List<Member> members = memberAgent.findAll();
      for (Member member : members) {
        response.println(String.format("%3d, %-4s, %-20s, %-15s, %s", 
            member.getNum(), member.getName(), 
            member.getEmail(), member.getTel(), member.getJoinDate()));
      }
  }
}
