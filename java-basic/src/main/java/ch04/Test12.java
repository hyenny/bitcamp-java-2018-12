// 논리 연산자 : &&, || vs &, |

package ch04;

public class Test12 {

  public static void main(String[] args) {
    // 괄호 연산
    int a= 5;
    int r = 10 / (a = 2);
    System.out.printf("%d, %d\n", a, r);
    
    // &&와 &의 차이점
    boolean b1 = true;
    boolean b2 = false && (b1 = false);
    System.out.printf("b1=%b, b2=%b\n",b1, b2);
    // && 연산자는 l-value의 값으로 결과를 유추할 수 있다면, r-value를 실행하지 않는다. 
    
    b1 = true;
    b2 = false & (b1 = false);
    System.out.printf("b1=%b, b2=%b\n",b1, b2);
    // & 연산자는 l-value의 값으로 결과가 결정되었다 하더라도 r-value를 끝까지 실행한다.
    
    b1 = true;
    b2 = true || (b1 = false);
    System.out.printf("b1=%b, b2=%b\n",b1, b2);
    
    b1 = true;
    b2 = true | (b1 = false);
    System.out.printf("b1=%b, b2=%b\n",b1, b2);


    
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
