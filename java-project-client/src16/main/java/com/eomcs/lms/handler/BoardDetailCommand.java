package com.eomcs.lms.handler;


import java.util.Scanner;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  BoardDaoImpl boardDao;
  
  public BoardDetailCommand(Scanner keyboard, BoardDaoImpl boardAgent) {
    this.keyboard = keyboard;
    this.boardDao = boardAgent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);
      System.out.printf("내용: %s\n", board.getContents());
      System.out.printf("작성일: %s\n", board.getWriteDate());

    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}

