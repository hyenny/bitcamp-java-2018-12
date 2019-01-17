package com.mycompany.proj.handler;

import com.mycompany.proj.domain.Lesson;

public class LessonList {
  static final int LENTH = 100;
  
  Lesson[] lessons;
  int size;
  
  
 public LessonList() {
   
   this.lessons = new Lesson[LENTH];

  }
  
  public Lesson[] toArray() {
    //전체 배열의 크기 100이라면,
    //현재 들어있는 항목만 따로 배열을 만들어 리턴한다. 
    Lesson[] arr = new Lesson[size];
    int i;
    
    for(i = 0; i< size; i++) {
      arr[i] = lessons[i];
    }
    
    return arr;
  }
  
  public void add(Lesson lesson) {

    lessons[size] = lesson;

    size++;
  }

}
