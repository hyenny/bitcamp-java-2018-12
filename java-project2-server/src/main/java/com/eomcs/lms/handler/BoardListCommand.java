package com.eomcs.lms.handler;


import java.util.List;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;


public class BoardListCommand extends AbstractCommand {

  BoardDaoImpl boardDao;
  
  public BoardListCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(Response response) throws Exception {
   
      List<Board> boards = boardDao.findAll();
      
      for (Board board : boards) {
        response.println(
            String.format("%3d, %-20s, %s, %d",
                board.getNum(), board.getContents(), 
                board.getWriteDate(), board.getHits()));
      }
      
  }

}
