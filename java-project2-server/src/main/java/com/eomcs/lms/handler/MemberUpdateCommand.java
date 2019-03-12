package com.eomcs.lms.handler;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand extends AbstractCommand {

  MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    int no = Integer.parseInt(response.requestString("번호?"));

    Member member = memberDao.findByNo(no);
    if (member == null) {
      response.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member temp = new Member();
    temp.setNum(no);

    String input = response.requestString(String.format("이름(%s)? ", member.getName()));
    if (input.length() > 0) 
      temp.setName(input);

    input = response.requestString(String.format("이메일(%s)? ", member.getEmail()));
    if (input.length() > 0)
      temp.setEmail(input);

    input = response.requestString(String.format("암호(%s)? ", member.getPassword()));
    if (input.length() > 0)
      temp.setPassword(input);

    input = response.requestString(String.format("사진(%s)? ", member.getPicture()));
    if (input.length() > 0)
      temp.setPicture(input);

    input = response.requestString(String.format("전화(%s)? ", member.getTel()));
    if (input.length() > 0)
      temp.setTel(input);

    if (temp.getName() != null
        || temp.getEmail() != null
        || temp.getPassword() != null
        || temp.getPicture() != null
        || temp.getTel() != null) {

      memberDao.update(temp);
      response.println("변경했습니다.");

    } else {
      response.println("변경 취소했습니다.");
    }


  }
}
