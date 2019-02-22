package com.eomcs.lms.handler;


import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberAddCommand extends AbstractCommand {

  MemberDaoImpl memberDao;

  public MemberAddCommand(MemberDaoImpl memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    
      Member member = new Member();

      member.setName(response.requestString("이름?"));
      member.setEmail(response.requestString("이메일?"));
      member.setPassword(response.requestString("암호?"));
      member.setPicture(response.requestString("사진?"));
      member.setTel(response.requestString("전화?"));


      memberDao.insert(member);
      response.println("저장하였습니다.");
  }
}
