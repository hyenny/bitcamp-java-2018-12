package com.mycompany.proj.handler;

import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardListCommand implements Command {

  Scanner keyboard;
  List<Board> list;

  public BoardListCommand(Scanner keyboard, List<Board> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    Board[] boards = new Board[list.size()];
    list.toArray(boards);
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNum(), board.getContents(), 
          board.getWriteDate(), board.getHits());
    }
  }



}
