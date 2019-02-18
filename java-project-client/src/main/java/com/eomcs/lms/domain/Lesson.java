
package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Lesson implements Cloneable, Serializable {
  private static final long serialVersionUID = 1L;
  
  private int num;
  private String className;
  private String contents;
  private Date startDate;
  private Date endDate;
  private int totalTime;
  private int dayTime;
  
  @Override
  public Lesson clone() throws CloneNotSupportedException {
    return (Lesson) super.clone();
  }
  
  
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getClassName() {
    return className;
  }
  public void setClassName(String className) {
    this.className = className;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getTotalTime() {
    return totalTime;
  }
  public void setTotalTime(int totalTime) {
    this.totalTime = totalTime;
  }
  public int getDayTime() {
    return dayTime;
  }
  public void setDayTime(int dayTime) {
    this.dayTime = dayTime;
  }
  
  /**
   * 
   * @param csv "번호,제목,내용,시작일(yyyy-MM-dd),종료일(yyyy-MM-dd),총강의시간,일강의시간"
   * @return
   */
  
  // 인스턴스 필드를 사용하지 않으므로 스태틱 메서드로 만든다.
  public static Lesson valueOf(String csv) {
    String[] values = csv.split(",");
    
    Lesson lesson = new Lesson();
    
    lesson.setNum(Integer.parseInt(values[0]));
    lesson.setClassName(values[1]);
    lesson.setContents(values[2]);
    lesson.setStartDate(Date.valueOf(values[3]));
    lesson.setEndDate(Date.valueOf(values[4]));
    lesson.setTotalTime(Integer.parseInt(values[5]));
    lesson.setDayTime(Integer.parseInt(values[6]));
    
    return lesson;
    
  }
  

}
