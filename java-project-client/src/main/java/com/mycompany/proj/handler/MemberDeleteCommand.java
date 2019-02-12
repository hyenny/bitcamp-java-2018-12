package com.mycompany.proj.handler;


import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Member;

public class MemberDeleteCommand implements Command {

  Scanner keyboard;
  List<Member> list;

  public MemberDeleteCommand(Scanner keyboard, List<Member> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfMember(no);
    if (index == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);

    System.out.println("회원을 삭제했습니다.");
  }

  private int indexOfMember(int no) {
    for (int i = 0; i < list.size(); i++) {
      Member l = list.get(i);
      if (l.getNum() == no)
        return i;
    }
    return -1;
  }


}

