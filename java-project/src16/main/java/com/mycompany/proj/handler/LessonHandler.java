
package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Lesson;

public class LessonHandler {
  
  Scanner keyboard; 
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    
  }
  
  LessonList lessonList = new LessonList();

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

    lessonList.add(lesson);

    System.out.println("저장하였습니다");
  }

  public void listLesson() {
    int i = 0;
    while (i < lessonList.toArray().length) {
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          lessonList.toArray()[i].getNum(), lessonList.toArray()[i].getClassName(),
          lessonList.toArray()[i].getStartDate(), lessonList.toArray()[i].getEndDate(), lessonList.toArray()[i].getTotalTime());
      i++;
    }

  }
}
