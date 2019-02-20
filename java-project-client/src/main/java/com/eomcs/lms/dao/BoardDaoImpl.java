
package com.eomcs.lms.dao;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {
  
  String serverAddr;
  int port;
  String rootPath;
  
  public BoardDaoImpl() {
  }
  
  @SuppressWarnings("unchecked")
  public List<Board> findAll() {
    
  }
  
  public void insert(Board board) {
    
    int id = board.getNum();
    String contents = board.getContents();
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");
      
      String sql = "insert into x_board(id,contents) values(id = ?, contents = ?)";
      try (PreparedStatement stmt = con.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        stmt.setString(2, contents);
        
        int count = stmt.executeUpdate();
        

        System.out.println(count);

        System.out.println("등록하였습니다.");
      }

    } catch (Exception e) {
      System.out.println("데이터베이스 접속 오류.");
      e.printStackTrace();
    }
    
   
  }
  
  public Board findByNo(int no) {
    

  }
  
  public int update(Board board) {
    
    
  }
  
  public int delete(int no) {
    
    
  }
}









