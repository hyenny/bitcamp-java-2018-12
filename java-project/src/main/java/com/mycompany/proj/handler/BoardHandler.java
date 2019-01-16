package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardHandler {
  
  Scanner keybored;
  
  public BoardHandler(Scanner keyboard) {
    this.keybored = keyboard;
  }
  
  BoardList boardList = new BoardList();
  
  public void addBoard() {
    
    Board board = new Board();
    
    board.setWriteDate(new Date(System.currentTimeMillis()));
    board.setHits(0);

    System.out.print("번호?:");
    board.setNum(Integer.parseInt(keybored.nextLine()));

    System.out.print("내용?:");
    board.setContents(keybored.nextLine());
    
    boardList.add(board);
    
    System.out.println("저장하였습니다");
   
  }
  
  public void listBoard() {
    
    for (int i = 0; i < boardList.toArray().length; i++) {
      System.out.printf("%3d, %-20s, %s, %d\n",
          boardList.toArray()[i].getNum(), boardList.toArray()[i].getContents(), 
          boardList.toArray()[i].getWriteDate(), boardList.toArray()[i].getHits());
    }
  }

}
