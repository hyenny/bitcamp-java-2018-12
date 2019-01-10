// 메서드 
package ch06;

import java.util.Scanner;

public class Test15 {
  public static void main(String[] args) {
    // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하다.
    // $ java -cp ./bin/main ch06.Test15 홍길동 100 100 90
    // 총점: 290
    // 평균: 96.9
    
    String name = args[0];
    int sum = 0;
    float avg = 0;
    
    if (args.length < 4) {
      System.out.println("이름, 국어점수, 영어점수, 수학점수 입력");
      return;
    }
    
    
    for (int i=1; i<args.length;i++)
      sum += Integer.parseInt(args[i]);
    
    avg = (float)(sum/(args.length-1));
    
    System.out.printf("이름: %s\n", name);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n", avg); // %.1f 소수점 1자리까지 출력
    
  
  }
  
}

/* 
 * # 프로그램 아규먼트(arguments)
 * - 프로그램을 실행할 때 넘겨주는 값.
 * - 어떻게 아규먼트를 넘기는가?
 *  $ java 클래스명 값1 값2 값3
 *  - 아규먼트는 공백으로 구분한다.
 *  - JVM은 아규먼트의 개수만큼 문자열 배열을 만들어 저장한다.
 *  - 아규먼트가 없으면 빈 배열을 만든다.
 *  - 그런후 main()을 호출할 때 그 배열의 주소를 넘겨준다.
  */
 