package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;


public class BoardListCommand implements Command {

  BoardDaoImpl boardDao;
  
  public BoardListCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      List<Board> boards = boardDao.findAll();
      
      for (Board board : boards) {
        out.printf("%3d, %-20s, %s, %d\n", 
            board.getNum(), board.getContents(), 
            board.getWriteDate(), board.getHits());
      }
      
    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }

}
