package com.mycompany.proj.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.mycompany.proj.domain.Board;
import com.mycompany.proj.domain.Lesson;

public class LessonAddCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonAddCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }


  @Override
  public void execute() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNum(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setClassName(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalTime(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayTime(Integer.parseInt(keyboard.nextLine()));

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }



}
