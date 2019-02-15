package com.mycompany.proj.handler;


import java.util.Scanner;
import com.mycompany.proj.agent.BoardAgent;
import com.mycompany.proj.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  BoardAgent boardAgent;
  
  public BoardDetailCommand(Scanner keyboard, BoardAgent boardAgent) {
    this.keyboard = keyboard;
    this.boardAgent = boardAgent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardAgent.get(no);
      System.out.printf("내용: %s\n", board.getContents());
      System.out.printf("작성일: %s\n", board.getWriteDate());

    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}

