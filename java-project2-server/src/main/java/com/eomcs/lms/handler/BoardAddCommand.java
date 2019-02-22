package com.eomcs.lms.handler;

import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;


public class BoardAddCommand extends AbstractCommand {

  BoardDaoImpl boardDao; // 서버의 BoardDaoImpl 객체를

  public BoardAddCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(Response response) throws Exception {

      Board board = new Board();

      board.setContents(response.requestString("내용?"));

      boardDao.insert(board);
      response.println("저장하였습니다.");
  }
  
}
