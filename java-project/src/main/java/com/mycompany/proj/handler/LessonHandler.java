package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.App;
import com.mycompany.proj.domain.Lesson;


public class LessonHandler {
  
  static Lesson[] lessons = new Lesson[App.NUMBER];
  static int l_idx = 0;

  public static void addLesson() {
    // lesson 입력
    Lesson lesson = new Lesson();
    Scanner keyboard = App.keyboard;

    System.out.print("번호?:");
    lesson.num = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명?:");
    lesson.className = keyboard.nextLine();

    System.out.print("수업내용?:");
    lesson.contents = keyboard.nextLine();

    System.out.print("시작일?:");
    lesson.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일?:");
    lesson.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간?:");
    lesson.totalTime = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간?:");
    lesson.dayTime = Integer.parseInt(keyboard.nextLine());

    lessons[l_idx] = lesson;

    l_idx++; 

  }

  public static void listLesson() {

    // lesson 출력
    int i = 0;
    while (i < l_idx) {
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          lessons[i].num, lessons[i].className, lessons[i].startDate, lessons[i].endDate, lessons[i].totalTime);
      i++;

    }
  }



}


