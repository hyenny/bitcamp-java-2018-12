// JVM 아규먼트 응용
package ch06;

import java.util.Scanner;

public class Test18 {
  public static void main(String[] args) {
    
    
    java.util.Properties props = System.getProperties();
    
    java.util.Set keySet = props.keySet();
    
    for (Object key : keySet) {
      String value = System.getProperty((String)key);
      System.out.printf("%s = %s\n", key, value);
    }
    
    
    
    
    
  
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
 