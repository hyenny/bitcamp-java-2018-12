package com.mycompany.proj.handler;


import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Lesson;
import com.mycompany.proj.proxy.LessonDaoProxy;


public class LessonListCommand implements Command {
  
  Scanner keyboard;
  LessonDaoProxy lessonDao;
  
  public LessonListCommand(Scanner keyboard, LessonDaoProxy lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }
  
  
  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonDao.findAll();
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
