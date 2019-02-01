// 문자 데이터 읽기
package ch22.d;

import java.io.FileReader;
import java.io.FileWriter;

public class Test01_2 {

  public static void main(String[] args) {

    // FileReader
    // => 문자 단위로 데이터를 읽는 일을 한다.
    //
    try (FileReader in = new FileReader("data.txt")) {

      // UTF-8 코드 값을 읽어서 UTF-16 코드 값으로 변환한 다음에 리턴한다.
      //
      // read()의 리턴 값은 UTF-16으로 바꾼 문자 코드 값이다.
      
      // 0x41 ==> 0x0041(UTF-16)
      System.out.println(Integer.toHexString(in.read()));

      // 0x42 ==> 0x0042(UTF-16)
      System.out.println(Integer.toHexString(in.read()));

      // 0x43 ==> 0x0043(UTF-16)
      System.out.println(Integer.toHexString(in.read()));

      // 0xeab080(UTF-8) ==> 0xac00(UTF-16)
      System.out.println(Integer.toHexString(in.read()));

      // 0xeab081(UTF-8) ==> 0xac01(UTF-16)
      System.out.println(Integer.toHexString(in.read()));

      // 0xeab084(UTF-8) ==> 0xac04(UTF-16)
      System.out.println(Integer.toHexString(in.read()));
      
      // JVM을 실행할 때 다음 옵션을 지정하지 않으면
      // -Dfile.encoding=문자표
      // JVM은 OS의 기본 문자표라고 가정하고 파일을 읽는다.

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
