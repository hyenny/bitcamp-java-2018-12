// 인스턴스 출력하기 - 배열 활용
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test02_2 {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    
    Score[] students = null;

    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // => 홍길동, 100, 100, 100, 300, 100
    // 


    try (FileInputStream in = new FileInputStream("score.data");
        // 버퍼 단위로 읽는 데코레이터를 붙인다 => 읽기 속도가 빠르다.
        BufferedInputStream in1 = new BufferedInputStream(in);
        // primitive type 데이터를 리턴하는 데코레이터를 붙인다. => 코딩이 간결해진다.
        DataInputStream in2 = new DataInputStream(in1)) {

      // 바이너리 데이터를 읽을 때는 저장한 순서(파일 포맷)에 맞춰 읽어야 한다.
      
      int len = in2.readInt();
      students = new Score[len];
      
      for (int i = 0; i <students.length; i++) {
        Score s = new Score();
        s.setName(in2.readUTF());
        s.setKor(in2.readInt());
        s.setEng(in2.readInt());
        s.setMath(in2.readInt());
        students[i] = s;
        
      }
      
      for (Score s : students) {
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
            s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
        
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("읽기 완료!");
  }

}


