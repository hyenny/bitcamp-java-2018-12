// 관계 연산자
package ch04;

public class Test06 {

  public static void main(String[] args) {
    System.out.println(10 <20 );
    System.out.println(10 <=20 );
    System.out.println(10 >20 );
    System.out.println(10 >=20 );
    System.out.println(10 ==20 );
    System.out.println(10 !=20 );
    
    
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
