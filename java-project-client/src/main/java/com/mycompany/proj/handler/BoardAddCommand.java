package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardAddCommand implements Command {

  Scanner keyboard;
  List<Board> list;

  // 생성자 : 인스턴스필드 초기화 메서드
  public BoardAddCommand(Scanner keyboard, List<Board> list) {
    this.keyboard = keyboard;
    this.list = list; 
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

    list.add(board);

    System.out.println("저장하였습니다.");
  }



}
