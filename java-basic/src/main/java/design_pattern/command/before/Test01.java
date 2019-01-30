package design_pattern.command.before;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    CommandHandler handler = new CommandHandler();
    Scanner keyboard = new Scanner(System.in);

    while (true) {
      System.out.print("명령>");
      String input = keyboard.nextLine();

      if ("/board/add".contentEquals(input)) {
        handler.addBoard();
      } else if ("/board/detail".equals(input)) {
        handler.detailBoard();

      } else if ("/board/list".equals(input)) {
        handler.listBoard();

      } else if ("/board/update".equals(input)) {
        handler.updateBoard();

      } else if ("/board/delete".equals(input)) {
        handler.deleteBoard();

      } else if ("/member/add".contentEquals(input)) {
        handler.addBoard();
      } else if ("/member/detail".equals(input)) {
        handler.detailBoard();

      } else if ("/memeber/list".equals(input)) {
        handler.listBoard();

      } else if ("/member/update".equals(input)) {
        handler.updateBoard();

      } else if ("/memeber/delete".equals(input)) {
        handler.deleteBoard();
      } else if ("quit".contentEquals(input)) {
        break;
      } else {
        System.out.println("처리할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboard.close();

  }
}


