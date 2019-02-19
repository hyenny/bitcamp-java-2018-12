// 스레드와 프로그램 종료
package ch24.c;

import java.util.Scanner;

public class Test03 {

  static class MyThread extends Thread {

    @Override
    public void run() {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("입력하시오> ");
      String input = keyboard.nextLine();
      System.out.println("입력한 문자열 => " + input);
      keyboard.close();
    }
  }
  

  public static void main(String[] args) throws Exception {
    
    Thread t = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("스레드 ===> %d\n", i);
        }
      }
    };
    t.start();
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("스레드2 >>>>>>>>>> %d\n", i);
        }
      }
    }).start();  // 스레드 객체 생성 => 준비 상태 => Running 상태
    
    // main 스레드를 5초 동안 Not Runnable 상태에 둔다.
    // 즉 main 스레드를 실행하지 않는다.
    Thread.currentThread().sleep(5000);
    
    // 주의!
    // => dead 상태에서 다시 실행할 수 없다.
    //t.start(); //예외 발생!
    
    for (int i = 0; i < 1000; i++) {
      System.out.printf("main() ~~~~> %d\n", i);
    }
    // main() 메서드의 코드를 모두 실행했다고 해서 JVM이 종료되는 것은 아니다.
    // 다른 스레드의 실행 모두 끝나야만 JVM이 종료된다.
  }

}
