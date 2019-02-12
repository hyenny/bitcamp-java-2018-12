package com.mycompany.proj.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Map;
import com.mycompany.proj.context.ApplicationListener;
import com.mycompany.proj.domain.Member;

public class MemberDataLoadListener implements ApplicationListener{
  
  
  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 시작될 때 준비할 작업을 수행한다.");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream("member.data")))) {
      
      context.put("memberList", in.readObject());

    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("memberList", new LinkedList<Member>());
    }
    
  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 종료될 때 마무리 작업을 수행한다.");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("member.data")))) {

      out.writeObject(context.get("memberList"));

    } catch (IOException e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
    }   
  }
  

}
