package algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
  static final int DEFAULT_SIZE = 5;
  Object[] arr;
  int size;
  
  public ArrayList() {
    this(0);
  }
  
  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else
      arr = new Object[DEFAULT_SIZE];
  }
  
  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      list[i] = this.arr[i];
    }
    return list;
  }
  
  public void add(Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    if(size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
    }
    arr[size] = value;
    size++; 
  }
  
  public int insert(int index, Object value) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 저장하지 말라.
    // 삽입할 위치의 항목부터 이후의 항목들을 뒤로 밀어라.
    
    if(index < 0 || index >= size)
      return -1;
    
    if (this.size == arr.length)
      increase();
    
    for (int i = size - 1; i >= index; i--)
      this.arr[i+1] = this.arr[i];
    
    this.arr[index] = value;
    size++;
    
    return 0;
    
    
    
//    if(index < 0 || index >= size)
//      return;
//    
//    Object temp = arr[size-1];
//
//   for(int i = size -1 ; i > index; i--) {
//     arr[i] = arr[i-1];
//    }
//    arr[index] = value;
//    size++;
//    arr[size] = temp;   
     
    
  }
  
  public Object get(int index) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 null을 리턴하라.
    if(index < 0 || index >= size)
      return null;
    
    return this.arr[index];
  }
  
  public Object set(int index, Object value) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 변경하지 말라. 리턴 값은 null이다.
    if(index < 0 || index >= size)
      return null;
    
    Object obj = arr[index];
    arr[index] = value;
    
    return obj;
  }
  
  public Object remove(int index) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 삭제하지 말라.
    // 삭제한 후 다음 항목을 앞으로 당긴다.
    if(index < 0 || index >= size)
      return null;
    
    Object old = this.arr[index];
    
    for(int i = index; i < size -1 ; i++) {
      arr[i] = arr[i+1];
    }
    
    size--;
    return old;
  }
  
  public int size() {
    return this.size;
  }
  
  private void increase() {
    int originSize = arr.length;
    int newSize = originSize + (originSize >> 1);
    Object[] temp = new Object[newSize];
    for (int i = 0; i < this.arr.length; i++) {
      temp[i] = this.arr[i];
    }
    arr = temp;
    
  }
  

}
