// 메서드 - 메서드 중첩 호출
package ch06;

public class Test06 {
  public static void main(String[] args) {
    
    int result = plus();
    System.out.println(result);
    
    result = plus(2);
    System.out.println(result);
    
    result = plus(2,3);
    System.out.println(result);
    
    result = plus(2,3,4);
    System.out.println(result);
    
    // 가변 파라미터인 경우 값을 배열에 담아서 넘겨도 된다.
    result = plus(new int[] {10,20,30});
    
    
                                                                                                                                                                             
  } 
  
  // 같은 타입의 값을 0개 이상 받을 때 가변 파라미터를 사용하라!
  static int plus(int... value) {
    // value는 int[] 배열 주소를 갖고 있는 레퍼런스(주소 변수)이다.
    //가변 파라미터는 배열 레퍼런스처럼 사용한다.
    int sum = 0; // <= 메서드 안에 선언된 변수를 "로컬 변수(local variable)"라 한다.
                   // <= 파라미터도 로컬 변수있니까? 예. 로컬 변수이다.
    for(int i = 0; i < value.length; i++) {
      sum += value[i];
    }
    return sum;
  }
}
