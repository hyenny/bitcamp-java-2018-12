package com.mycompany.util;

import java.util.Arrays;
import com.mycompany.proj.domain.Board;
import com.mycompany.proj.domain.Lesson;
import com.mycompany.proj.domain.Member;


public class ArrayList<E> {
  static final int LENTH = 100;

  Object[] list;
  int size;

  public ArrayList() {

    this.list = new Object[LENTH]; 

  }


  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
     */
  }

  
      
  public void add(E obj) {
    if (size == list.length) {
      //boards 배열을 기존 배열의 length + length의 절반을 더해서 copy한다.
      Arrays.copyOf(list, list.length + (list.length >> 1)); 
    }

    list[size] = obj;
    size++;
  }


  public int size() {
    // TODO Auto-generated method stub
    return this.size;
  }


  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    return (E) list[index];
  }


  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    E obj = (E) list[index];

    for(int i = index; i < size - 1; i++)
      list[i] = list[i+1];

    size--;
    return obj;

  }


  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    
    E obj = (E) list[index];
    
    list[index] = value;
    
    return obj;
    
  }
} 
