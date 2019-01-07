// 부동 소수점의 비교 오류
package ch04;

public class Test07 {

  public static void main(String[] args) {
    float f1 = 0.1f;
    float f2 = 0.1f;
    
    System.out.println(f1 * f1 == 0.01f); //false
    
    //why?
    System.out.println(f1 * f1); //0.010000001 값 나옴. 0.000000001의 오차 발생
    
    
    
    float r = f1 * f2 - 0.01f;
    System.out.println(((f1 * f1) - 0.01f)<= Float.POSITIVE_INFINITY);
    
    
  }
  
  
    
}

/* 
 # 연산자 우선 순위
 괄호
 후위 연산자: a++, a--
 전위 연산자: ++a, --a, 단항 연산자(+, -)
 *, /, %
 +, -
 비트이동 연산자: <<, >>, >>>
 관계 연산자 : <, >, <=, >=, instanceof
 등위 연산자 : ==, !=
 &
 ^
 |
 논리 연산자 AND: &&
 논리 연산자 OR: ||
 삼항 연산자 : (조건) ? 값 : 값
 할당 연산자 : =, +=, -=, *=, /=, %=, ^= */
