package com.mycompany.proj.handler;

import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Lesson;

public class LessonDetailCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonDetailCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfLesson(no);
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    Lesson lesson = list.get(index);

    System.out.printf("수업명: %s\n", lesson.getClassName());
    System.out.printf("설명: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalTime());
    System.out.printf("일수업시간: %d\n", lesson.getDayTime());
  }
  
  private int indexOfLesson(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNum() == no)
        return i;
    }
    return -1;
  }



}
