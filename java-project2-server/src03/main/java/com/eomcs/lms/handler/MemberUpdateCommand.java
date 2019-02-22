package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  MemberDaoImpl memberDao;

  public MemberUpdateCommand(MemberDaoImpl memberDao) {
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

      Member temp = member.clone();

      out.printf("이름(%s)? ", member.getName());
      out.println();
      out.println("!{}!");
      out.flush();
      String input = in.readLine();
      if (input.length() > 0) 
        temp.setName(input);

      out.printf("이메일(%s)? ", member.getEmail());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setEmail(input);

      out.printf("암호(********)? ");
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setPassword(input);

      out.printf("사진(%s)? ", member.getPicture());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setPicture(input);

      out.printf("전화(%s)? ", member.getTel());
      out.println();
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setTel(input);

      memberDao.update(temp);
      out.println("변경했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
