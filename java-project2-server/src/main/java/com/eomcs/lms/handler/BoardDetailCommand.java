package com.eomcs.lms.handler;


import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand extends AbstractCommand {


  BoardDaoImpl boardDao;

  public BoardDetailCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(Response response) throws Exception {

      int no = Integer.parseInt(response.requestString("번호?"));

      Board board = boardDao.findByNo(no);
      response.println(String.format("내용: %s", board.getContents()));
      response.println(String.format("작성일: %s", board.getWriteDate()));
  }
}

