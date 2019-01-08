// 논리 연산자 : &, |
package ch04;

public class Test11 {

  public static void main(String[] args) {
    
    //피연산자가 boolean 타입일 때는 &&, ||와 동일하게 수행한다
    
    //&& (AND) 논리 연산자
    // => 피 연산자 모두 true일 때만 결과가 true 된다.
    System.out.println(true & true);
    System.out.println(true & false);
    
   //|| (OR) 논리 연산자
    // => 둘 중 한 개라도 true이면 결과가 true이다.
    System.out.println(true | false);
    System.out.println(false | false);
    
    //피연산자가 정수일 때는 비트 연산을 수행한다.
    // 비트연산? 비트와 비트끼리 and, or 연산을 수행한다.
    // 1(true), 0(false)
    int a = 0xca; //0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; //0000 0000 0000 0000 0000 0000 0110 0110
    
    System.out.println(a & b); // 0000 0000 0000 0000 0000 0000 0100 0010 => 66
    
    System.out.println(a | b); // 0000 0000 0000 0000 0000 0000 1110 1110 => 238
    
    
    
   
  
    
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
