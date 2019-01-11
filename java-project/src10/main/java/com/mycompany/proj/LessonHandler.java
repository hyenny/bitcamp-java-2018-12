package com.mycompany.proj;

import java.sql.Date;
import java.util.Scanner;


public class LessonHandler {
  
  static int l_idx = 0;

  static void addLesson() {
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

    App.lessons[l_idx] = lesson;

    l_idx++; 

  }

  static void listLesson() {

    // lesson 출력
    int i = 0;
    while (i < l_idx) {
      System.out.printf("%d, %-20s, %s ~ %s, %d\n", 
          App.lessons[i].num, App.lessons[i].className, App.lessons[i].startDate, App.lessons[i].endDate, App.lessons[i].totalTime);
      i++;

    }
  }



}


