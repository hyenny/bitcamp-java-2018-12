
package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.proj.domain.Lesson;
import com.mycompany.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;

  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>();

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

    list.add(lesson);

    System.out.println("저장하였습니다");
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[0]);
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNum(), lesson.getClassName(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalTime());
    }
  }

  public void detailLesson() {
    
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return ;
    
    Lesson lesson = list.get(index);

    System.out.printf("수업명: %s\n", lesson.getClassName());
    System.out.printf("수업내용: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalTime());
    System.out.printf("일수업시간: %d\n", lesson.getDayTime());

  }


  public void deleteLesson() {
    
    int no = promptLessonNo();
    int index = indexOf(no); 
    if (!validate(index))
      return ;

    list.remove(index);
    System.out.println("수업을 삭제했습니다.");

  }


  public void updateLesson() {
    
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return ;
    
    Lesson lesson = list.get(index);
    Lesson temp = new Lesson();
    
    temp.setNum(lesson.getNum());
    
   

    System.out.printf("수업명(%s)? ", lesson.getClassName());
    String input = keyboard.nextLine();
    if(input.length() > 0) {
      temp.setClassName(input);
    } else {
      temp.setClassName(lesson.getClassName());
    }

    System.out.printf("수업내용? ");    
    input = keyboard.nextLine();
    temp.setContents(input.length() > 0 ? input : lesson.getContents());

    System.out.printf("시작일(%s)? ", lesson.getStartDate());
    input = keyboard.nextLine();
    temp.setStartDate(input.length() > 0 ?
        Date.valueOf(input) : lesson.getStartDate());

    System.out.printf("종료일(%s)? ", lesson.getEndDate());
    input = keyboard.nextLine();
    temp.setEndDate(input.length() > 0 ?
        Date.valueOf(input) : lesson.getEndDate());

    System.out.printf("총수업시간(%d)? ", lesson.getTotalTime());
    input = keyboard.nextLine();
    temp.setTotalTime(input.length() > 0 ?
        Integer.parseInt(input) : lesson.getTotalTime());


    System.out.printf("일수업시간(%d)? ", lesson.getDayTime());
    input = keyboard.nextLine();
    temp.setDayTime(input.length() > 0 ?
        Integer.parseInt(input) : lesson.getDayTime());

    list.set(index, temp);


  }
  

  private int indexOf(int lessonNo) {

    int size = list.size();
    for (int i = 0; i < size; i++) {
      Lesson item = list.get(i);
      if(item.getNum() == lessonNo) {
        return i;
      }
    }

    return -1;
  }
  
  private int promptLessonNo() {
    
    System.out.print("번호?:");
    return Integer.parseInt(keyboard.nextLine());
    
  }
  
  private boolean validate(int index) {
    
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return false;
    }
    return true;
    
  }
}

