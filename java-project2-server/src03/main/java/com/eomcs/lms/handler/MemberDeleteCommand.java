package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;


public class MemberDeleteCommand implements Command {

  MemberDaoImpl memberDao;

  public MemberDeleteCommand(MemberDaoImpl memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();
      int no = Integer.parseInt(in.readLine());


      memberDao.delete(no);
      out.println("삭제했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
