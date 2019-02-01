// primitive data type의 값을 출력하기
package ch22.c;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Test03_2 {

  public static void main(String[] args) {

    // IO Stream 클래스
    // 1). data sink stream class
    //      => 파일이나 메모리에서 직접 데이터를 읽고 쓰는 클래스
    //      => 파일: 
   //        FileInputStream/FileOutputStream,
   //        FileReader/FileWriter
    //      => 메모리:
    //       ByteArrayInputStream/ByteArrayOutputStream
    //       CharArrayReader/CharArrayWriter
    //       StringReader/StringWriter
    //      => 프로세스: 다른 프로그램과 연결되어 데이터를 읽고 쓴다.
    //          PipedInputStream/PipedOutputStream
    //          PipedReader/PipeWriter
    //
    // 2). data processiong stream class
    //    => 데이터를 읽고 쓸 때 중간에서 데이터를 가공하는 클래스
    //    => 데코레이터 역할을 수행한다.
    //    => java.io.FilterInputStream/FilterOutputStream의 서브 클ㄹ스이다.
    //       FilterReader/FilterWriter의 서브 클래스이다.
    //        
    // 바이너리 스트림과 문자 스트림 클래스
    // 1). binary stream class
    //      => 바이트 단위로 데이터를 다루는 클래스이다.
    //    => InputStream/OutputStream의 서브 클래스이다.
    //      => 보통 클래스의 InputStream/OutputStream 로 끝난다.
    // 2). character stream class
    //      => 문자 단위로 데이터를 다루는 클래스이다.
    //      => 데이터를 입출력 할 때 UTF-16을 다른 문자표의 코드 값으로 자동 변환해준다.
    //    => Reader/Writer의 서브 클래스이다.
    //      => 보통 클래스 이름이 Reader/Writer로 끝난다.
    //

  }

}
