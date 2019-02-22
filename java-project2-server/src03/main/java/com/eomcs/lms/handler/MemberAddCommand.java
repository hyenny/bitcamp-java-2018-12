package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberAddCommand implements Command {

  MemberDaoImpl memberDao;

  public MemberAddCommand(MemberDaoImpl memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      Member member = new Member();

      out.println("이름? ");
      out.println("!{}!");
      out.flush();
      member.setName(in.readLine());

      out.println("이메일? ");
      out.println("!{}!");
      out.flush();
      member.setEmail(in.readLine());

      out.println("암호? ");
      out.println("!{}!");
      out.flush();
      member.setPassword(in.readLine());

      out.println("사진? ");
      out.println("!{}!");
      out.flush();
      member.setPicture(in.readLine());

      out.println("전화? ");
      member.setTel(in.readLine());


      memberDao.insert(member);
      out.println("저장하였습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
