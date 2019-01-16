package com.mycompany.proj.handler;

import com.mycompany.proj.domain.Board;

public class BoardList {
  static final int LENTH = 100;
  
  Board[] boards;
  int b_idx;
  
  
 public BoardList() {
   
   this.boards = new Board[LENTH];

  }
  
  public Board[] toArray() {
    //전체 배열의 크기 100이라면,
    //현재 들어있는 항목만 따로 배열을 만들어 리턴한다. 
    Board[] arr = new Board[b_idx];
    int i;
    
    for(i = 0; i< b_idx; i++) {
      arr[i] = boards[i];
    }
    
    return arr;
  }
  
  public void add(Board board) {

    boards[b_idx] = board;

    b_idx++;
  }

}
