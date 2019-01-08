// 논리 연산자 : &&, ||, ^
package ch04;

public class Test10 {

  public static void main(String[] args) {
    
    //&& (AND) 논리 연산자
    // => 피 연산자 모두 true일 때만 결과가 true 된다.
    System.out.println(true && true);
    System.out.println(true && false);
    
   //|| (OR) 논리 연산자
    // => 둘 중 한 개라도 true이면 결과가 true이다.
    System.out.println(true || false);
    System.out.println(false || false);
    
    // ^ (exclusive OR) 논리 연산자
    // => 피연산자가 서로 다를 때만 true이다.
    System.out.println(true ^ true);
    System.out.println(false ^ false);
    System.out.println(true ^ false);
    
    //논리 연산자의 피연산자 값은 반드시 true 또는 false이어야 한다. 
    //System.out.println(1 && 1); //컴파일 오류!
    
    
    
   
  
    
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
