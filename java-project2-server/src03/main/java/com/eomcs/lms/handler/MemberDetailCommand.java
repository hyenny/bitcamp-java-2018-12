package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberDetailCommand implements Command {
  
  MemberDaoImpl memberDao;
  
  public MemberDetailCommand(MemberDaoImpl memberDao) {
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.readLine());

   
      Member member = memberDao.findByNo(no);
      if (member == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }
      
      out.printf("이름: %s\n", member.getName());
      out.printf("이메일: %s\n", member.getEmail());
      out.printf("사진: %s\n", member.getPicture());
      out.printf("전화: %s\n", member.getTel());
      out.printf("가입일: %s\n", member.getJoinDate());
      
    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }

  }
}
