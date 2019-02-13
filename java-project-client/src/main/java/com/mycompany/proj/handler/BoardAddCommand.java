package com.mycompany.proj.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;

public class BoardAddCommand implements Command {

  Scanner keyboard;

  // 생성자 : 인스턴스필드 초기화 메서드
  public BoardAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }


  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNum(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setWriteDate(new Date(System.currentTimeMillis())); 

    board.setHits(0);
    
    try {
    out.writeUTF("/board/add"); 
    out.flush();
    if (!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    
    out.writeObject(board);
    out.flush();
    
    String status = in.readUTF();
    
    if (!status.equals("OK"))
      throw new Exception("서버에 전송 실패!");
    
    System.out.println("저장하였습니다.");

    } catch (Exception e) {
      
      System.out.printf("게시글 저장 오류! : %s\n", e.getMessage());
      
    }
    
  }



}
