package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileDaoImpl implements PhotoFileDao {

  // 외부에서 커넥션 객체를 주입 받는다.
  Connection con;

  public PhotoFileDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public List<PhotoFile> findByPhotoBoardNo(int photoBoardNo) {
    try (PreparedStatement stmt = con.prepareStatement(
        "select photo_file_id, photo_id, file_path"
        + " from lms_photo_file"
        + " where photo_id = ? "
        + " order by photo_file_id asc")) {

      stmt.setInt(1, photoBoardNo); // 특정 사진 게시물에 대해 첨부파일을 가져오기
      
      try (ResultSet rs = stmt.executeQuery()) {

        ArrayList<PhotoFile> list = new ArrayList<>();
        while (rs.next()) {
          PhotoFile photoFile = new PhotoFile();
          photoFile.setNo(rs.getInt("photo_file_id"));
          photoFile.setPhotoBoardNo(rs.getInt("photo_id"));
          photoFile.setFilePath(rs.getString("file_path"));

          list.add(photoFile);
        }
        return list;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void insert(PhotoFile photoFile) {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo_file(file_path,photo_id) values(?,?)")) {

      stmt.setString(1, photoFile.getFilePath());
      stmt.setInt(2, photoFile.getPhotoBoardNo());
      stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  
  @Override
  public int update(PhotoFile photoFile) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_photo set titl = ? where photo_id = ?")) {

      stmt.setString(1,photoFile.getTitle());
      stmt.setInt(2,photoFile.getNo());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  

  
  @Override
  public int deleteByPhotoBoardNo(int photoBoardNo) {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo where photo_id = ?")) {

      stmt.setInt(1, photoBoardNo);

      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}