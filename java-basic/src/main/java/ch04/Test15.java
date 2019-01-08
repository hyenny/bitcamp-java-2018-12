// 비트 연산자 : 
package ch04;

public class Test15 {

  public static void main(String[] args) {
    // >>> 
    // => 오른쪽으로 비트를 이동시킨다. 
    // => 
    
   int a = 0xca; // = 202
   System.out.println(Integer.toHexString(a >> 4)); //
   System.out.println(a >>> 4);
   
   
   System.out.println(Integer.toHexString(a >> 3)); // 
   System.out.println(a >>> 3);
  
   
   System.out.println(Integer.toHexString(a >> 2)); // 
   System.out.println(a >>> 2);
   
   System.out.println(Integer.toHexString(a >> 1)); // 
   System.out.println(a >>> 1);
   
   
   
   a = -202; 
   System.out.println(a >>> 1); // 
   
   System.out.println(a >>> 2); // 
   System.out.println(a >>> 3); // 
   System.out.println(a >>> 4); //
   System.out.println(Integer.MAX_VALUE);
   
               
   
    
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
