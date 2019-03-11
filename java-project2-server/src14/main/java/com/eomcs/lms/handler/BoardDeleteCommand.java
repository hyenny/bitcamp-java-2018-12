package com.eomcs.lms.handler;

import com.eomcs.lms.dao.mariadb.BoardDaoImpl;

public class BoardDeleteCommand extends AbstractCommand {

  BoardDaoImpl boardDao;

  public BoardDeleteCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = Integer.parseInt(response.requestString("번호?")); 
      if (boardDao.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      } 
      response.println("삭제했습니다.");
  }
}