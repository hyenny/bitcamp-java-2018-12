// 흐름제어문 - 반복문 :  while, do ~while, 

package ch05;

public class Test08 {
  

  public static void main(String[] args) {
    int a = 1;
    
    while (a <= 10) 
      System.out.print(a++ + " ");
    
    System.out.println();
    a = 1;
    while (a <= 10) {
      System.out.print(a + " ");
      a++;
    }
    
    while (a <= 10) {
      System.out.print(a + " ");
      a++;
      
      if (a > 5)
        break;
    }
    
    while (a <= 10) {
      if ( a % 2 == 0) {
        a++;
        continue; // 짝수이면 다음 코드를 실행하지 않고 조건 검사로 바로 올라간다.
      }
      
      System.out.print(a + " ");
      a++;
    }
    
    }
    
    
   
        
        
}

/* while 문법
 * 
 * while (조건) 문장1;
 *  
 * while (조건) {
 *  문장 1;
 *  문장 2;
 * }
 *   
 */


