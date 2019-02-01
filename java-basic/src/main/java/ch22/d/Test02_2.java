// 문자 데이터 읽기
package ch22.d;

import java.io.FileReader;
import java.io.FileWriter;

public class Test02_2 {

  public static void main(String[] args) {

    // FileReader
    // => 문자 단위로 데이터를 읽는 일을 한다.
    //
    try (FileReader in = new FileReader("data.txt")) {

      char[] cbuf = new char[1024]; // char 한 문자. -> 1024문자 (바이트x)
      int len = in.read(cbuf);
      
      System.out.println(len);
      for (int i = 0; i <len; i++) {
        System.out.println(cbuf[i] + ",");
      }
      System.out.println();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // character stream 클래스 FileWriter는 문자 데이터를 출력할 때
    // 자바 내부에서 문자열을 다룰 때 사용하는 UTF-16 코드를
    // OS의 기본 character set 코드로 값을 변환하여 출력한다.
    //
    // Linux, macOS의 기본 character set => UTF-8
    // Windows의 기본 character set => MS-949
    //
    // 따라서 같은 프로그램을 어느 OS에서 실행하느냐에 따라
    // 출력되는 코드 값이 달라진다.
    //
    // OS에 상관없이 동일한 character set으로 출력하고 싶다면
    // JVM을 실행할 때 file.encoding 프로퍼티애 character set 이름을 지정하라.
    // 예) java -Dfile.encoding=UTF-8 클래스명
    // 단, character set을 지정할 때는 해당 OS에서 사용가능한 문자표이어야 한다.
    // MS Windows에서는 ms949 문자표를 사용할 수 있지만,
    // 리눅스나 macOS에서는 ms949 문자표를 사용할 수 없다.
    // 왜? 국제 표준이 아니기 때문이다.
    // 결론!
    // => 무슨 OS를 사용하든지 출력할 때는 가능한 국제 표준인 UTF-8을 사용하라.



    System.out.println("출력 완료!");

  }

}
