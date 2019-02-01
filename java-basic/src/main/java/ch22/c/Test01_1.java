// 버퍼 사
package ch22.c;

import java.io.FileInputStream;


public class Test01_1 {

  public static void main(String[] args) {

    try {
      // 1). 데이터 출력을 담당할 객체를 생성한다.
      FileInputStream in = new FileInputStream("jls11.pdf");
      
      long start = System.currentTimeMillis();
      
      
      int b;
      int count = 0;
      while ((b = in.read()) != -1) {
        if (++count % 1000 == 0)
          System.out.print(".");
        if (count % 20000 == 0)
          System.out.println();
      }
      System.out.println();
      
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
      
      in.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
    
   

  }

}
