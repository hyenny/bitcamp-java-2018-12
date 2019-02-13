
package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Cloneable, Serializable {

  private static final long serialVersionUID = 1L;
  private int num;
  private String name;
  private  String email;
  private String password;
  private String picture;
  private String tel;
  private Date joinDate;
  
  public Member() {
  }
  
  public Member(int num, String name) {
    this.num = num;
    this.name = name;
  }
  
  

  @Override
  public String toString() {
    return "Member [num=" + num + ", name=" + name + ", email=" + email + ", password=" + password
        + ", picture=" + picture + ", tel=" + tel + ", joinDate=" + joinDate + "]";
  }

  @Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }


  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPicture() {
    return picture;
  }
  public void setPicture(String picture) {
    this.picture = picture;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public Date getJoinDate() {
    return joinDate;
  }
  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  //인스턴스 필드를 사용하지 않으므로 스태틱 메서드로 만든다.
  public static Member valueOf(String csv) {
    String[] values = csv.split(",");

    Member member = new Member();

    member.setNum(Integer.parseInt(values[0]));
    member.setName(values[1]);
    member.setEmail(values[2]);
    member.setPassword(values[3]);
    member.setPicture(values[4]);
    member.setTel(values[5]);
    member.setJoinDate(Date.valueOf(values[6]));

    return member;

  }



}
