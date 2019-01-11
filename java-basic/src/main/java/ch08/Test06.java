// 클래스 문법의 또다른 용도
package ch08;

import java.util.Scanner;

public class Test06 {


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("계산식?(예: 12 * 2) : ");
    int a = keyboard.nextInt();
    String op = keyboard.next();
    int b = keyboard.nextInt();
    
    keyboard.close();
    
    int result = 0;
    switch(op) {
      case "+":
        result = a + b;
        break;
      case "-":
        result = a - b;
        break;
      case "*":
        result = a * b; 
        break;
      case "/":
        result = a / b;
        break;
      default:
        System.out.println("지원하지 않는 연산자입니다");
        return; // main() 메서드를 그만 실행하고 나간다. 
          
        
    }
    
    System.out.printf("%d %s %d = %d\n", a, op, result);
    
  
    
  }

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }
  
  static int divide(int a, int b) {
    return a / b;
  }
  
}


/*
 * 클래스 문법의 용도
 * 1). 새 데이터 타입을 정의할 때
 * 2). 관련 메서드를 분류할 때
 */
