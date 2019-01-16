
package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Lesson;

public class LessonHandler {
  static final int LENTH = 10;

  int l_idx;
  Lesson[] lessons = new Lesson[LENTH];
  
  Scanner keyboard; 
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    
  }

  public void addLesson() {
    // lesson 입력
    Lesson lesson = new Lesson(); 

    System.out.print("번호?:");
    lesson.setNum(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명?:");
    lesson.setClassName(keyboard.nextLine());

    System.out.print("수업내용?:");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일?:");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일?:");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간?:");
    lesson.setTotalTime(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간?:");
    lesson.setDayTime(Integer.parseInt(keyboard.nextLine()));

    lessons[l_idx] = lesson;

    l_idx++; 
  }

  public void listLesson() {
    int i = 0;
    while (i < l_idx) {
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          lessons[i].getNum(),lessons[i].getClassName(), lessons[i].getStartDate(), lessons[i].getEndDate(), lessons[i].getTotalTime());
      i++;
    }

  }
}
