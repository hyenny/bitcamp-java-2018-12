
package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Cloneable, Serializable {
  
  private static final long serialVersionUID = 1L;
  private int num;
  private String contents;
  private int hits;
  private Date writeDate;
  
  @Override
  public Board clone() throws CloneNotSupportedException {
    return (Board) super.clone();
  }
  
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
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
  
//인스턴스 필드를 사용하지 않으므로 스태틱 메서드로 만든다.
  public static Board valueOf(String csv) {
    String[] values = csv.split(",");

    Board board = new Board();

    board.setNum(Integer.parseInt(values[0]));
    board.setContents(values[1]);
    board.setHits(Integer.parseInt(values[2]));
    board.setWriteDate(Date.valueOf(values[3]));

    return board;

  }
 


}
