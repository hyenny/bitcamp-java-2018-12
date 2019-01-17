package com.mycompany.proj.handler;

import java.util.Arrays;
import com.mycompany.proj.domain.Board;

public class BoardList {
  static final int LENTH = 100;
  
  Board[] boards;
  int size;
  
  
 public BoardList() {
   
   this.boards = new Board[LENTH];

  }
  
  public Board[] toArray() {
    //전체 배열의 크기 100이라면,
    //현재 들어있는 항목만 따로 배열을 만들어 리턴한다. 
    Board[] arr = new Board[size];
    int i;
    
    for(i = 0; i< size; i++) {
      arr[i] = boards[i];
    }
    
    return arr;
  }
  
  public void add(Board board) {
    if (size == boards.length) {
      //boards 배열을 기존 배열의 length + length의 절반을 더해서 copy한다.
      Arrays.copyOf(boards, boards.length + (boards.length >> 1));
      
      /*
      Board[] arr = new Board[boards.length + (boards.length >> 1)];
      for(int i = 0; i < boards.length;  i++) {
        arr[i] = boards[i];
      }
      boards = arr;
      */
    }

    boards[size] = board;

    size++;
  }

}
