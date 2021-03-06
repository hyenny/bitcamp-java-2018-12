package com.mycompany.proj.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import com.mycompany.proj.context.ApplicationListener;
import com.mycompany.proj.domain.Board;

public class BoardDataLoadListener implements ApplicationListener {

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 시작될 때 준비할 작업을 수행한다.");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream("board.data")))) {

      context.put("boardList", in.readObject());

    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("boardList", new ArrayList<Board>());
    }

  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 종료될 때 마무리 작업을 수행한다.");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("board.data")))) {

      out.writeObject(context.get("boardList"));

    } catch (IOException e) {
      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
}


