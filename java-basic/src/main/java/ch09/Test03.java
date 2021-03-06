// 클래스 필드의 한계
package ch09;

public class Test03 {

  public static void main(String[] args) {
    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    // Calcutator2의 result 변수는 오직 한 개만 존재한다.
    // 따라서 다음과 같이 두 개의 계산식을 동시에 수행할 수 없다.
    
   Calculator2.plus(2); // 식 1 계산 => 2
   Calculator2.plus(6); // 식 2 계산 => 6 을 생각하겠지만 실제는 2 + 6이 된다.
   
   Calculator2.multiple(3); // 식 1 => 2 * 3 을 생각하겠지만 실제는 2 + 6 + 3이 된다.
   Calculator2.divide(2); // 식 2 => 6 / 2
   
   Calculator2.minus(2); // 식 1 => 2 * 3 - 2
   Calculator2.plus(8); // 식 2 => 6 / 2 + 8
   
   Calculator2.plus(7);
    
    System.out.println(Calculator2.result);
    
    // 동시에 계산식을 수행하는 방법은 없을까?
    // Calculator2는 불가능하다.
    // 오히려 Calculator1은 가능하다.
    
    
   
  }

}
