// 버퍼 사
package ch22.c;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test01_2 {

  public static void main(String[] args) {

    try {
      // 1). 데이터 출력을 담당할 객체를 생성한다.
      FileInputStream in = new FileInputStream("jls11.pdf");
      
      System.out.println("데이터 읽는 중...");
      
      long start = System.currentTimeMillis();
      
      byte[] buf = new byte[1000];
      int len = 0;
      
      while ((len = in.read(buf)) != -1) {
        //
      }
      
  
      
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
      
      in.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
    
   

  }

}
