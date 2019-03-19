//프로퍼티 값 변환기
package ch29.g;

import java.sql.Date;

public class Car {
  private String maker;
  private String model;
  private int cc;
  private int value;
  private boolean auto;
  private Date createdDate;
  private BlackBox blackBox;
  
  
  
  
  @Override
  public String toString() {
    return "Car [maker=" + maker + ", model=" + model + ", cc=" + cc + ", value=" + value
        + ", auto=" + auto + ", createdDate=" + createdDate + ", blackBox=" + blackBox + "]";
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public int getValue() {
    return value;
  }
  public void setValue(int valve) {
    this.value = valve;
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
    this.auto = auto;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public BlackBox getBlackBox() {
    return blackBox;
  }
  public void setBlackBox(BlackBox blackBox) {
    this.blackBox = blackBox;
  }

  

 
  
}
