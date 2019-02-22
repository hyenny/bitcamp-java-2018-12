package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;

public class BoardDeleteCommand implements Command {

  BoardDaoImpl boardDao;

  public BoardDeleteCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.readLine());

    
      if (boardDao.delete(no) == 0) {
        out.println("해당 번호의 게시물이 없습니다.");
        return;
      } 
      out.println("삭제했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}