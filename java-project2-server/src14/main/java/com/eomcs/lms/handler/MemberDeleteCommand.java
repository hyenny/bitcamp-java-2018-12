package com.eomcs.lms.handler;


import com.eomcs.lms.dao.mariadb.MemberDaoImpl;


public class MemberDeleteCommand extends AbstractCommand {

  MemberDaoImpl memberDao;

  public MemberDeleteCommand(MemberDaoImpl memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    try {
      int no = Integer.parseInt(response.requestString("번호?"));


      memberDao.delete(no);
      response.println("삭제했습니다.");

    } catch (Exception e) {
      response.println(String.format("실행 오류! : %s\n", e.getMessage()));
    }
  }
}
