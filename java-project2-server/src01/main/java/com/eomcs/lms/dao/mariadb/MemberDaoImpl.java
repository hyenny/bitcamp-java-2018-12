package com.eomcs.lms.dao.mariadb;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;


public class MemberDaoImpl implements MemberDao {

  Connection con;
  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  public List<Member> findAll() {
    try {
      try (PreparedStatement stmt = con.prepareStatement(
          "select member_id, name, email, tel, cdt from lms_member"
              + " order by member_id desc")) {

        try (ResultSet rs = stmt.executeQuery()) {

          List<Member> list = new ArrayList<>();
          while (rs.next()) {
            Member member = new Member();
            member.setNum(rs.getInt("member_id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setTel(rs.getString("tel"));
            member.setJoinDate(rs.getDate("cdt"));

            list.add(member);
          }
          return list;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }


  public void insert(Member member) {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_member(name, email, pwd, tel, photo)"
            + " values(?, ?, password(?), ?, ?)")) {

      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getTel());
      stmt.setString(5, member.getPicture());

      stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }

  public Member findByNo(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_id, name, email, photo, tel, cdt from lms_member where member_id = ?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
          Member member = new Member();
          member.setNum(rs.getInt("member_id"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPicture(rs.getString("photo"));
          member.setTel(rs.getString("tel"));
          member.setJoinDate(rs.getDate("cdt"));
          
          return member;
        } else {
          return null;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Member member) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_member set name = ?, email = ?, pwd = password(?), cdt = ?, tel = ?, photo = ?"
        + " where member_id = ?")) {

      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setDate(4, member.getJoinDate());
      stmt.setString(5, member.getTel());
      stmt.setString(6, member.getPicture());
      stmt.setInt(7, member.getNum());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_member where member_id = ?")) {
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}













