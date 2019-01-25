// 데이터 관리 객체(ArrayList, LinkedList 등)를 사용하는 규칙을 정하기.
package com.mycompany.util;


public interface List<E> {

  Object[] toArray();
  <T> T[] toArray(T[] a);
  void add(E obj);
  E get(int index);
  E set(int index, E value);
  E remove(int index); 
  int size();
  
} 
