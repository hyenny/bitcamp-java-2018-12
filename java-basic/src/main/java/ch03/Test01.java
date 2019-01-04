
package ch03;

public class Test01 {

    public static void main(String[] args) {
        
      // 1바이트 정수 값을 담을 메모리 준비
      byte b1;
      byte b2;
      byte b3;
      
      b1 = -128; //리터럴 값이 비록 4바이트 크기이지만 메모리에 넣을 수 있다면 허락한다.
      //b2 = 127L; //단 8바이트 값은 담을 수 있더라도 허락하지 않는다. (컴파일 오류!)
      b2 = 127;
      //b2 = 128; //128은 1바이트 메모리에 담을 수 없기 때문에 컴파일 오류가 발생한다.
      
      // 2바이트 정수 값을 담을 메모리 준비
      short s1;
      short s2;
      short s3;
      
      s1 = -32768;
      s2 = 32767;
      //s2 = 300L; //컴파일 오류
      //s3 = 32768; //컴파일 오
      
      //4바이트 정수 값을 담을 메모리 준비
      int i1;
      int i2;
      int i3;
      
      i1 = -2100000000;
      i2 = 2100000000;
      //i2 = 2100000000L; //컴파일 오류!
      //i3 = 2200000000; //리터럴 표현 오류
      
      // 8바이트 정수 값을 담을 메모리 준비
      long l1;
      long l2;
      long l3;
      
      l1 = 9200000000000000000L;
      
      
      // 4바이트 부동소수점을 담을 메모리 준비
      float f1;
      float f2;
      float f3;
      
      f1 = 98765.43f;
      f2 = 98765.43456789f; //유효 자릿수를 넘어 가는 경우 짤려서 저장된다.
                                //정수 메모리와 달리 컴파일 오류가 발생하지 않는다.
                                //그래서 더더욱 주의해서 사용해야 한다.
      
      f1 = 9876.543f;
      f2 = 12.34567f;
      
      System.out.println(f1);
      System.out.println(f2);
      
      

      
      
      // 8바이트 부동소수점을 담을 메모리 준비
      double d1;
      double d2;
      double d3;
      
      d1 = 98765.43; 
      d2 = 98765.43456789;
      
      System.out.println(d1);
      System.out.println(d2); // 유효자리수 15자리까지 대부분 짤리지 않고 들어간다.
      
     
      // 논리 값을 담을 메모리 준비
      boolean bool1;
      boolean bool2;
      boolean bool3;
      
      bool1 = true;
      bool2 = false;
      //bool3 = 1;
      
      
      // 문자의 UTF-16 코드 값을 담을 메모리 준비
      char ch1;
      char ch2;
      char ch3;
      
      ch1 = 44032; // 4바이트 정수 리터럴이라도 0 ~ 655535까지의 값이라면 
                   //char 메모리에 저장하는 것을 허락한다.
      ch2 = 0xac00;
      ch3 = '가'; //''의 리턴 값은 2바이트(0 ~ 65535) 유니코드 정수 값이다.
      
      System.out.println(ch1);
      System.out.println(ch2);
      System.out.println(ch3);
      
      
    

    }
    
}

//#변수
// - 값을 저장하는 메모리
// 
// # 변수 선언
// - 값을 저장하는 메모리를 준비하는 명령