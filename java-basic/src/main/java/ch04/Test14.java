// 비트 연산자 : 
package ch04;

public class Test14 {

  public static void main(String[] args) {
    // >> : 오른쪽으로 비트를 이동시킨다. 왼쪽 빈자리는 부호비트로 채운다.
    
   int a = 0xca; // = 202
   System.out.println(Integer.toHexString(a >> 4)); // 0xc = 12
   System.out.println(a >> 4);
   //00000000_00000000_00000000_11001010
   //    0000_00000000_00000000_00001100|1010
   //00000000_00000000_00000000_00001100 
   
   System.out.println(Integer.toHexString(a >> 3)); // 0x19 = 25
   System.out.println(a >> 3);
   //00000000_00000000_00000000_11001010
   //   00000_00000000_00000000_00011001|010
   //00000000_00000000_00000000_00011001
   
   System.out.println(Integer.toHexString(a >> 2)); // 0x32 = 50
   System.out.println(a >> 2);
   
   System.out.println(Integer.toHexString(a >> 1)); // 0x65 = 101
   System.out.println(a >> 1);
   
   // 오른쪽 비트 이동의 효과
   // => 1비트 이동할 때마다 2로 나누는 효과가 있다.
   // => 예) n에 대해 x비트를 오른쪽으로 이동 = n / 2**x
   // => 나누기 연산을 수행하는 것보다 계산 속도가 빠르다.
   
   // 음수 값에 대해 오른쪽으로 비트 이동
   // => 2**n으로 나눈 것과 같다
   // => 소수점 이하를 반올림 한 결과가 ㅏㄴ온다.
   // => 왼쪽 빈자리가 부호비트로 채워진다.
   a = -202; // 11111111_11111111_11111111_00110110 = 0xff_ff_ff_36
   System.out.println(a >> 1); // -101
   
   System.out.println(a >> 2); // = 202 / 2**2 = -51
   
   System.out.println(a >> 3); // -202 / 2**3 = -26
   
   System.out.println(a >> 4); // = -202 / 2**4 = -13 
   
               
   
    
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
