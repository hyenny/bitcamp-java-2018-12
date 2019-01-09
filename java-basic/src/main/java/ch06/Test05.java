// 메서드 - 메서드 중첩 호출
package ch06;

public class Test05 {
  public static void main(String[] args) {
    int result = plus(2, 3);
    result = plus(result, 4); // result 변수가 넘어가는 것이 아니라 result 변수의 값이 넘어 간다. 
    result = plus(result, 5); 
    System.out.println(result);
    
    result = plus(plus(plus(2, 3), 4), 5);
                                                                                                                                                                                                                                                  
  } 
  
  static String greet(String name) {
    return name + "님 반갑습니다!";
  }
  
  static int plus(int a, int b) {
    return a+b;
  }
}
