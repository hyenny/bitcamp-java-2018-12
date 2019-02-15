package com.mycompany.proj.handler;


import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.agent.BoardAgent;
import com.mycompany.proj.domain.Board;


public class BoardListCommand implements Command {

  Scanner keyboard;
  BoardAgent boardAgent;
  
  public BoardListCommand(Scanner keyboard, BoardAgent boardAgent) {
    this.keyboard = keyboard;
    this.boardAgent = boardAgent;
  }

  @Override
  public void execute() {
    try {
      List<Board> boards = boardAgent.list();
      
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
