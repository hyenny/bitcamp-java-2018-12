package com.mycompany.proj;

import java.sql.Date;
import java.util.Scanner;

public class BoardHandler {
  
  static int b_idx = 0;

  static void addBoard() {
    // board 입력
    Board board = new Board();
    Scanner keyboard = App.keyboard;

    board.writeDate = new Date(System.currentTimeMillis());
    board.hits = 0;

    System.out.print("번호?:");
    board.num = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용?:");
    board.contents = keyboard.nextLine();

    App.boards[b_idx] = board;

    b_idx++;

  }

  static void listBoard() {
    // board 출력
    int i = 0;
    while(i < b_idx) {
      System.out.printf("%d, %s, %s, %d\n", App.boards[i].num, App.boards[i].contents, App.boards[i].writeDate, App.boards[i].hits);
      i++;
    }

  }



}


