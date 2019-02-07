// 인스턴스 출력하기 - ObjectInputStream
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test04_2 {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    
    ArrayList<Score> students = new ArrayList<>();
    


    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // => 홍길동, 100, 100, 100, 300, 100
    // 


    // ObjectInputStream
    // => DataInputStream의 기능을 포함한다.
    // => ObjectOutputStream.writeObject()로 출력한 바이트 배열을 읽어
    //      인스턴스를 생성하는 기능이 있다.
    // => 단 java.io.Serializable 인터페이스를 구현한 클래스여야 한다.
    //    출력할 때 클래스 버전과 읽을 때 클래스의 버전이 같아야 한다.
    // => 인스턴스 필드를 생성한 후 직접 필드에 값을 저장한다.
    //    이 때는 생성자가 호출되지 않는다.
    //    따라서 초기화시킬 것이 있다면 따로 메서드를 호출해야 한다.
    
    try (FileInputStream in = new FileInputStream("score.data");
        // 버퍼 단위로 읽는 데코레이터를 붙인다 => 읽기 속도가 빠르다.
        BufferedInputStream in1 = new BufferedInputStream(in);
        // primitive type 데이터를 리턴하는 데코레이터를 붙인다. => 코딩이 간결해진다.
        ObjectInputStream in2 = new ObjectInputStream(in1)) {

      // 바이너리 데이터를 읽을 때는 저장한 순서(파일 포맷)에 맞춰 읽어야 한다.
      
      int len = in2.readInt();
      
      for (int i = 0; i < len; i++) {
        
        Score score = (Score) in2.readObject();
        // 저장한 인스턴스 필드 값을 그대로 읽을 것이기 떄문에
        // sum과
        students.add(score);
       
        
        
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


