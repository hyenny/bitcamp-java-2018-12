package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class PhotoBoard implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private int num;
  private String title;
  private int hits;
  private Date writeDate;
  private int lessonNo;
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public int getHits() {
    return hits;
  }
  public void setHits(int hits) {
    this.hits = hits;
  }
  public Date getWriteDate() {
    return writeDate;
  }
  public void setWriteDate(Date writeDate) {
    this.writeDate = writeDate;
  }
  public int getLessonNo() {
    return lessonNo;
  }
  public void setLessonNo(int lessonNo) {
    this.lessonNo = lessonNo;
  }
  
  

}
