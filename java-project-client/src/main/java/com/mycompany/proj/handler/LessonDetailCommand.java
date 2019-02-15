package com.mycompany.proj.handler;


import java.util.Scanner;
import com.mycompany.proj.agent.LessonAgent;
import com.mycompany.proj.domain.Lesson;

public class LessonDetailCommand implements Command {

  Scanner keyboard;
  LessonAgent lessonAgent;
  
  public LessonDetailCommand(Scanner keyboard, LessonAgent lessonAgent) {
    this.keyboard = keyboard;
    this.lessonAgent = lessonAgent;
  }
  

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Lesson lesson = lessonAgent.get(no);
      System.out.printf("수업명: %s\n", lesson.getClassName());
      System.out.printf("설명: %s\n", lesson.getContents());
      System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
      System.out.printf("총수업시간: %d\n", lesson.getTotalTime());
      System.out.printf("일수업시간: %d\n", lesson.getDayTime());
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }

  }
}
