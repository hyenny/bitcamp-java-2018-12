// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01_1 {

  public static void main(String[] args) {

    // 다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장하라.
    // => java.io.BufferedOutputStream 클래스를 사용하라
    // => java.io.DataOutputStream 클래스를 사용하라.


    try (FileOutputStream out = new FileOutputStream("score.data");
        // 버퍼 데코레이터를 붙인다. => 출력 속도 빨라진다. 
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        // primitive type 변환 데코레이터를 붙인다 => 특정 타입의 값을 출력하기 편하다.
        DataOutputStream out2 = new DataOutputStream(out1)) {

      Score s1 = new Score("홍길동", 100, 100, 100);
      Score s2 = new Score("임꺽정", 90, 90, 90);
      Score s3 = new Score("유관순", 80, 80, 80);



      out2.writeUTF(s1.getName());
      out2.writeInt(s1.getKor());
      out2.writeInt(s1.getEng());
      out2.writeInt(s1.getMath());
      
            
      out2.writeUTF(s2.getName());
      out2.writeInt(s2.getKor());
      out2.writeInt(s2.getEng());
      out2.writeInt(s2.getMath());

      
      out2.writeUTF(s3.getName());
      out2.writeInt(s3.getKor());
      out2.writeInt(s3.getEng());
      out2.writeInt(s3.getMath());
      
      out2.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");

  }
}