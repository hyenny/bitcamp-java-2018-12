package com.eomcs.lms.dao.mariadb;



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;


public class LessonDaoImpl implements LessonDao {

  public LessonDaoImpl () {
  }

  @SuppressWarnings("unchecked")
  public List<Lesson> findAll() {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from lms_lesson"
              + " order by lesson_id desc")) {

        try (ResultSet rs = stmt.executeQuery()) {

          List<Lesson> list = new ArrayList<>();
          while (rs.next()) {
            Lesson lesson = new Lesson();
            lesson.setNum(rs.getInt("lesson_id"));
            lesson.setClassName(rs.getString("titl"));
            lesson.setContents(rs.getString("conts"));
            lesson.setTotalTime(rs.getInt("tot_hr"));
            lesson.setDayTime(rs.getInt("day_hr"));
            lesson.setStartDate(rs.getDate("sdt"));
            lesson.setEndDate(rs.getDate("edt"));

            list.add(lesson);
          }
          return list;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  public void insert(Lesson lesson) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into lms_lesson(sdt, edt, tot_hr, day_hr, titl, conts)"
              + " values(?,?,?,?,?,?)")) {

        stmt.setDate(1, lesson.getStartDate());
        stmt.setDate(2, lesson.getEndDate());
        stmt.setInt(3, lesson.getTotalTime());
        stmt.setInt(4, lesson.getDayTime());
        stmt.setString(5, lesson.getClassName());
        stmt.setString(6, lesson.getContents());

        stmt.executeUpdate();
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public Lesson findByNo(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from lms_lesson where lesson_id = ?")) {

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) {

          if (rs.next()) {
            Lesson lesson = new Lesson();
            lesson.setNum(rs.getInt("lesson_id"));
            lesson.setClassName(rs.getString("titl"));
            lesson.setContents(rs.getString("conts"));
            lesson.setDayTime(rs.getInt("day_hr"));
            lesson.setTotalTime(rs.getInt("tot_hr"));
            lesson.setStartDate(rs.getDate("sdt"));
            lesson.setEndDate(rs.getDate("edt"));

            return lesson;
          } else {
            return null;
          }
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public int update(Lesson lesson) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_lesson set sdt = ?, edt = ?, tot_hr = ?, day_hr = ?, titl = ?, conts = ?"
              + " where lesson_id = ?")) {


        stmt.setDate(1, lesson.getStartDate());
        System.out.println(stmt);

        stmt.setDate(2, lesson.getEndDate());
        stmt.setInt(3, lesson.getTotalTime());
        stmt.setInt(4, lesson.getDayTime());
        stmt.setString(5, lesson.getClassName());
        stmt.setString(6, lesson.getContents());
        stmt.setInt(7, lesson.getNum());

        System.out.println(stmt);
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
          "delete from lms_lesson where lesson_id = ?")) {

        stmt.setInt(1, no);

        return stmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


}

















