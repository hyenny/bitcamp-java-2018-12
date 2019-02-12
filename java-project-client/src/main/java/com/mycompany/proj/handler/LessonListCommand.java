package com.mycompany.proj.handler;

import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Lesson;

public class LessonListCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonListCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    Lesson[] lessons = list.toArray(new Lesson[0]);
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNum(), lesson.getClassName(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getDayTime());
    }
  }
  


}
