package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;
import com.mycompany.proj.proxy.BoardDaoProxy;


public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  BoardDaoProxy boardDao; // 서버의 BoardDaoImpl 객체를
  
  public BoardAddCommand(Scanner keyboard, BoardDaoProxy boardAgent) {
    this.keyboard = keyboard;
    this.boardDao = boardAgent;
  }
  
  @Override
  public void execute() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNum(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setWriteDate(new Date(System.currentTimeMillis())); 
    
    board.setHits(0);
    
    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
