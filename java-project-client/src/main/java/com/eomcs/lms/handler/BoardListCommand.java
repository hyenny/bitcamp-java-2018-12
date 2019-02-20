package com.eomcs.lms.handler;


import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.domain.Board;


public class BoardListCommand implements Command {

  Scanner keyboard;
  BoardDaoImpl boardDao;
  
  public BoardListCommand(Scanner keyboard, BoardDaoImpl boardAgent) {
    this.keyboard = keyboard;
    this.boardDao = boardAgent;
  }

  @Override
  public void execute() {
    try {
      List<Board> boards = boardDao.findAll();
      
      for (Board board : boards) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
            board.getNum(), board.getContents(), 
            board.getWriteDate(), board.getHits());
      }
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }

}
