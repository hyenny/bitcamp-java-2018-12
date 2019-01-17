package com.mycompany.proj.handler;

import java.util.Arrays;
import com.mycompany.proj.domain.Board;
import com.mycompany.proj.domain.Lesson;
import com.mycompany.proj.domain.Member;


public class ArrayList {
  static final int LENTH = 100;

  Object[] list;
  int size;

  public ArrayList() {

    this.list = new Object[LENTH]; 
    
  }


  public Object[] toArray() {
    //전체 배열의 크기 100이라면,
    //현재 들어있는 항목만 따로 배열을 만들어 리턴한다. 
    Object[] arr = new Object[size];
    int i;

    for(i = 0; i< size; i++) {
      arr[i] = list[i];
    }

    return arr;
  }

  public void add(Object obj) {
    if (size == list.length) {
      //boards 배열을 기존 배열의 length + length의 절반을 더해서 copy한다.
      Arrays.copyOf(list, list.length + (list.length >> 1)); 
    }

    list[size] = obj;
    size++;
  }
} 
