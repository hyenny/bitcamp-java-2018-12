// DBVMS 적용
package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  public List<Board> findAll() {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try (PreparedStatement stmt = con.prepareStatement(
          "select board_id, conts, cdt, vw_cnt from lms_board"
              + " order by board_id desc")) {

        try (ResultSet rs = stmt.executeQuery()) {

          List<Board> list = new ArrayList<>();
          while (rs.next()) {
            Board board = new Board();
            board.setNum(rs.getInt("board_id"));
            board.setContents(rs.getString("conts"));
            board.setWriteDate(rs.getDate("cdt"));
            board.setHits(rs.getInt("vw_cnt"));

            list.add(board);

          }
          return list;
        }

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  public void insert(Board board) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into lms_board(conts) values(?)")) {

        stmt.setString(1, board.getContents());
        stmt.executeUpdate();
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public Board findByNo(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      // 조회수 증가시키기
      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_board set vw_cnt = vw_cnt + 1 where board_id = ?")) {
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }

      try (PreparedStatement stmt = con.prepareStatement(
          "select board_id, conts, cdt, vw_cnt from lms_board where board_id = ?")) {

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) {

          if (rs.next()) {
            Board board = new Board();
            board.setNum(rs.getInt("board_id"));
            board.setContents(rs.getString("conts"));
            board.setWriteDate(rs.getDate("cdt"));
            board.setHits(rs.getInt("vw_cnt"));
            return board;
          } else {
            return null;
          }
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  public int update(Board board) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_board set conts = ? where board_id = ?")) {

        stmt.setString(1, board.getContents());
        stmt.setInt(2, board.getNum());

        return stmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  public int delete(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "delete from lms_board where board_id = ?")) {

        stmt.setInt(1, no);

        return stmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}









