// 부동소수점 값을 다룰 때 주의 할 
package ch03;

public class Testxx {

    public static void main(String[] args) {
        
      
      
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
      
      f3 = f1+f2;
      
      System.out.println(f3);

      
      
      // 8바이트 부동소수점을 담을 메모리 준비
      double d1;
      double d2;
      double d3;
      
      d1 = 98765.43; 
      d2 = 98765.43456789;
      
      System.out.println(d1);
      System.out.println(d2); // 유효자리수 15자리까지 대부분 짤리지 않고 들어간다.
      
      
      d3 = f1+f2;
      System.out.println("f1+f2="+d3);
      
     
   
    }
    
}

