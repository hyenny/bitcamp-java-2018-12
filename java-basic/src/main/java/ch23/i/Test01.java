// Base64 인코딩
package ch23.i;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Test01 {
  public static void main(String[] args) throws Exception {
    String str = "ABCD12가각간";
    
    byte[] bytes = str.getBytes("UTF-8");
    
    // Base64 인코딩
    // => 바이너리 데이터를 문자화시킨다.
    // => 바이너리 값을 6비트씩 잘라서(2의 6승)
    //      64진수로 만든 후 Base64 표에 정의된 대로
    //      해당 값을 문자로 변환한다.
    // => 보통 바이너리 데이터를 텍스트로 전송하고 싶을 때 많이 사용한다.
    // => "ABC012가간" 문자열
    
    Encoder encoder = Base64.getEncoder();
    byte[] base64Bytes = encoder.encode(bytes);
    
    System.out.println(new String(base64Bytes));
    
    // Base64 디코딩
    // => Base64 코드를 원래의 바이너리 값으로 변환한다.
    //
    Decoder decoder = Base64.getDecoder();
    byte[] bytes2 = decoder.decode(base64Bytes);
   
    System.out.println(new String(bytes2, "UTF-8"));
    
  }

}
