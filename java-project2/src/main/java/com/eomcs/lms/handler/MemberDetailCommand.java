package com.eomcs.lms.handler;


import java.util.Scanner;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.domain.Member;


public class MemberDetailCommand implements Command {
  
  Scanner keyboard;
  MemberDaoImpl memberDao;
  
  public MemberDetailCommand(Scanner keyboard, MemberDaoImpl memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Member member = memberDao.findByNo(no);
      if (member == null) {
        System.out.println("해당 번호의 회원이 없습니다.");
        return;
      }
      
      System.out.printf("이름: %s\n", member.getName());
      System.out.printf("이메일: %s\n", member.getEmail());
      System.out.printf("사진: %s\n", member.getPicture());
      System.out.printf("전화: %s\n", member.getTel());
      System.out.printf("가입일: %s\n", member.getJoinDate());
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }

  }
}
