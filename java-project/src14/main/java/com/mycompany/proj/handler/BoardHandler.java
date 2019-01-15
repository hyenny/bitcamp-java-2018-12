package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardHandler {
  
  static final int LENTH = 10;
  
  int b_idx;
  Board[] boards = new Board[LENTH]; 
  
  Scanner keyboard;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    
  }
  
  public void addBoard() {
    Board board = new Board();
    
    board.writeDate = new Date(System.currentTimeMillis());
    board.hits = 0;

    System.out.print("번호?:");
    board.num = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용?:");
    board.contents = keyboard.nextLine();
    
    boards[b_idx] = board;

    b_idx++;
  }
  
  public void listBoard() {
    for (int i = 0; i < b_idx; i++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[i].num, boards[i].contents, 
          boards[i].writeDate, boards[i].hits);
    }
  }

}
