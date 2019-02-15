package com.mycompany.proj.handler;


import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.agent.LessonAgent;
import com.mycompany.proj.domain.Lesson;


public class LessonListCommand implements Command {
  
  Scanner keyboard;
  LessonAgent lessonAgent;
  
  public LessonListCommand(Scanner keyboard, LessonAgent lessonAgent) {
    this.keyboard = keyboard;
    this.lessonAgent = lessonAgent;
  }
  
  
  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonAgent.list();
      for (Lesson lesson : lessons) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
            lesson.getNum(), lesson.getClassName(), 
            lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalTime());
      }
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
