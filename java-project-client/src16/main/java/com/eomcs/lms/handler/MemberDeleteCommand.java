package com.eomcs.lms.handler;


import java.util.Scanner;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;


public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberDaoImpl memberDao;
  
  public MemberDeleteCommand(Scanner keyboard, MemberDaoImpl memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    try {
      memberDao.delete(no);
      System.out.println("삭제했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
