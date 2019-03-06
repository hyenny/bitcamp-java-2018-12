package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.DataSource;

public class LessonDaoImpl implements LessonDao {

  // DataSource 의존 객체 선언
  DataSource dataSource;
  
  public LessonDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public List<Lesson> findAll() {
    Connection con = dataSource.getConnection();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "select lesson_id, titl, sdt, edt, tot_hr from lms_lesson"
        + " order by lesson_id desc")) {
      
      try (ResultSet rs = stmt.executeQuery()) {
        
        ArrayList<Lesson> list = new ArrayList<>();
        while (rs.next()) {
          Lesson lesson = new Lesson();
          lesson.setNum(rs.getInt("lesson_id"));
          lesson.setClassName(rs.getString("titl"));
          lesson.setStartDate(rs.getDate("sdt"));
          lesson.setEndDate(rs.getDate("edt"));
          lesson.setTotalTime(rs.getInt("tot_hr"));
          
          list.add(lesson);
        }
        return list;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Lesson lesson) {
    Connection con = dataSource.getConnection();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_lesson(titl,conts,sdt,edt,tot_hr,day_hr)"
        + " values(?,?,?,?,?,?)")) {
      
      stmt.setString(1, lesson.getClassName());
      stmt.setString(2, lesson.getContents());
      stmt.setDate(3,lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalTime());
      stmt.setInt(6, lesson.getDayTime());
      
      stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Lesson findByNo(int no) {
    Connection con = dataSource.getConnection();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "select lesson_id, titl, conts, sdt, edt, tot_hr, day_hr"
        + " from lms_lesson"
        + " where lesson_id = ?")) {
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery()) {
      
        if (rs.next()) {
          Lesson lesson = new Lesson();
          lesson.setNum(rs.getInt("lesson_id"));
          lesson.setClassName(rs.getString("titl"));
          lesson.setContents(rs.getString("conts"));
          lesson.setStartDate(rs.getDate("sdt"));
          lesson.setEndDate(rs.getDate("edt"));
          lesson.setTotalTime(rs.getInt("tot_hr"));
          lesson.setDayTime(rs.getInt("day_hr"));
          return lesson;
          
        } else {
          return null;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Lesson lesson) {
    Connection con = dataSource.getConnection();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_lesson set"
        + " titl = ?,"
        + " conts = ?,"
        + " sdt = ?,"
        + " edt = ?,"
        + " tot_hr = ?,"
        + " day_hr = ?"
        + " where lesson_id = ?")) {
      
      stmt.setString(1, lesson.getClassName());
      stmt.setString(2, lesson.getContents());
      stmt.setDate(3, lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalTime());
      stmt.setInt(6, lesson.getDayTime());
      stmt.setInt(7, lesson.getNum());
      
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    Connection con = dataSource.getConnection();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_lesson where lesson_id = ?")) {
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}









