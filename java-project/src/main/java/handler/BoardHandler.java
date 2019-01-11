package handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.App;
import domain.Board;

public class BoardHandler {
  
  static int b_idx = 0;
  static Board[] boards = new Board[App.NUMBER]; 

  public static void addBoard() {
    // board 입력
    Board board = new Board();
    Scanner keyboard = App.keyboard;

    board.writeDate = new Date(System.currentTimeMillis());
    board.hits = 0;

    System.out.print("번호?:");
    board.num = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용?:");
    board.contents = keyboard.nextLine();

    boards[b_idx] = board;

    b_idx++;

  }

  public static void listBoard() {
    // board 출력
    int i = 0;
    while(i < b_idx) {
      System.out.printf("%d, %s, %s, %d\n", boards[i].num, boards[i].contents, boards[i].writeDate, boards[i].hits);
      i++;
    }

  }



}


