// Serialize - serialVersionUID 스태틱 필드 사용하기
package ch22.f;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test03_2 {
  public static void main(String[] args) {
    
    // deserialize
    // => Score3 클래스를 변경하지 않고 읽어 본다
    //     정상적으로 읽을 수 있을 것이다.
    // => Score3에 tel 필드와 getter/setter를 추가하고,
    //    toString()을 다시 생성한 후
    //    score3.data 파일을 읽어보라.
    //     단 
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("score3.data"))) {
      
      Score3 score = (Score3) in.readObject();
      score.compute();
      System.out.println(score);
      
      // Score2 클래스를 변경한 후 이 클래스를 이용하여
      // serialize 된 데이터를 읽어들이면 예외가 발생한다.
      // 예외 분석:
      // => java.io.Serializable 구현체는 내부적으로
      //     serialVersionUID라는 스태틱 변수가 자동으로 생긴다.
      //     serialize 되는 데이터의 파일 버전 역할을 한다.
      //  => serialVersionUID 값을 개발자가 지정하지 않으면
      //       컴파일할 때 자동으로 부여된다.
      // => Score2 클래스 또한 이 변수가 존재하고,
      //     score2.data 파일로 인스턴스를 출력할 때
      //       이 변수의 값이 함께 저장된다.
      //  => Score2 클래스를 변경하게 되면 이 변수의 값이 자동으로 새로 부여된다.
      // => ObjectInputStream.readObject()는
      //    score2.data 파일을 읽을 때 함께 저장된 serialVersionUID 값과
      //     deserialize 할 때 사용할 Score2 클래스의 serialVersionUID 값을
      //      비교하여 같다면 파일의 데이터를 읽어 인스턴스를 생성하여 리턴하고,
      //      다르다면 예외를 발생시킨다.
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
