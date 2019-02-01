
package ch22.c;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Test02_1 {

  public static void main(String[] args) {

    FileOutputStream out = null;
    
    try {

      out = new FileOutputStream("data.bin");

      System.out.println("데이터 쓰는 중...");
      long start = System.currentTimeMillis();

      for (int i = 0; i < 1000000; i++) {
        out.write(0x55);
      }


      long end = System.currentTimeMillis();

      System.out.println(end - start);

      out.close();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try { out.close(); } catch (Exception e) {} //close하다가 예외가 발생할 수 있다.
    }

    System.out.println("출력 완료!");



  }

}
