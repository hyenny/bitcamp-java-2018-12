package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  BoardDaoImpl boardDao;

  public BoardUpdateCommand(BoardDaoImpl boardAgent) {
    this.boardDao = boardAgent;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      Board board = new Board();

      out.println("번호? ");
      out.println("!{}!");
      out.flush();
      board.setNum(Integer.parseInt(in.readLine()));

      out.println("내용? ");
      out.println("!{}!");
      out.flush();
      board.setContents(in.readLine());

      if (boardDao.update(board) == 0) {
        out.println("해당 번호의 게시물이 없습니다.");
        return;
      }

      out.println("변경했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
