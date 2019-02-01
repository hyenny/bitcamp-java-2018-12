// 버퍼를 적용하여 데이터 읽기를 대신 처리해주는 도우미 클래스 사용
package ch22.c;

import java.io.FileInputStream;


public class Test01_3 {

  public static void main(String[] args) {

    try {
      // 1). 데이터 출력을 담당할 객체를 생성한다.
      FileInputStream in = new FileInputStream("jls11.pdf");
      BufferdInputStream in2 = new BufferdInputStream(in);
      
      long start = System.currentTimeMillis();
      
      
      int b;
      int count = 0;
      while ((b = in.read()) != -1) {
        count++;
      }
      System.out.println();
      
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
      System.out.println(count);
      
      in.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
    
   

  }

}
