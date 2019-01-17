package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardHandler {

  Scanner keybored;

  public BoardHandler(Scanner keyboard) {
    this.keybored = keyboard;
  }

  ArrayList boardList = new ArrayList();

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
    Object[] objs = boardList.toArray();
    for (Object obj : objs) {
      Board board = (Board) obj;
      System.out.printf("%3d, %-20s, %s, %d\n",
          board.getNum(), board.getContents(), 
          board.getWriteDate(), board.getHits());
    }
  }

}
