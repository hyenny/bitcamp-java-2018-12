// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test01_2 {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {

    // score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;

    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // => 홍길동, 100, 100, 100, 300, 100
    // 

    // 데코레이터 디자인 패턴의 장점은
    // => 기능을 붙이고 떼기가 쉽다.
    //
    try (FileInputStream in = new FileInputStream("score.data");
        // 버퍼 단위로 읽는 데코레이터를 붙인다 => 읽기 속도가 빠르다.
        BufferedInputStream in1 = new BufferedInputStream(in);
        // primitive type 데이터를 리턴하는 데코레이터를 붙인다. => 코딩이 간결해진다.
        DataInputStream in2 = new DataInputStream(in1)) {

      // 바이너리 데이터를 읽을 때는 저장한 순서(파일 포맷)에 맞춰 읽어야 한다.

      s1 = new Score(in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
      s2 = new Score(in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
      s3 = new Score(in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
      

      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.getName(), s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAver());
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s2.getName(), s2.getKor(), s2.getEng(), s2.getMath(), s2.getSum(), s1.getAver());
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s3.getName(), s3.getKor(), s3.getEng(), s3.getMath(), s3.getSum(), s3.getAver());
      

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("읽기 완료!");
  }

}


