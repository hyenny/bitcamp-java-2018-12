package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;


public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  BoardDaoImpl boardDao; // 서버의 BoardDaoImpl 객체를
  
  public BoardAddCommand(Scanner keyboard, BoardDaoImpl boardAgent) {
    this.keyboard = keyboard;
    this.boardDao = boardAgent;
  }
  
  @Override
  public void execute() {
    Board board = new Board();
        
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
