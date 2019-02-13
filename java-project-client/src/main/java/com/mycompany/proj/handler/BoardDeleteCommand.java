package com.mycompany.proj.handler;

import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardDeleteCommand implements Command {

  Scanner keyboard;
  List<Board> list;

  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }


  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      if (b.getNum() == no)
        return i;
    }
    return -1;
  }
  
  



}
