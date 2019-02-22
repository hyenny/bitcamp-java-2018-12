package com.eomcs.lms.handler;


import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {


  BoardDaoImpl boardDao;

  public BoardDetailCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();
      int no = Integer.parseInt(in.readLine());

      Board board = boardDao.findByNo(no);
      out.printf("내용: %s\n", board.getContents());
      out.printf("작성일: %s\n", board.getWriteDate());

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}

