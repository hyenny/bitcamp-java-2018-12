
package com.mycompany.proj.domain;

import java.sql.Date;

public class Lesson implements Cloneable {

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
  

}
