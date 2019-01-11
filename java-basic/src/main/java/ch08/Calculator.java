package ch08;

// 계산 기능과 관련된 메서드를 별도의 블록으로 분리하는 문법이 클래스

public class Calculator { 
  
  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }
  
  static int divide(int a, int b) {
    return a / b;
  }
  
  static int abs(int a) {
    /*
     * if (a>=0)
     *  return a;
     *  else
     *  return a * -1;
     */
    return (a >= 0) ? a : a * -1;
  }
 

}


