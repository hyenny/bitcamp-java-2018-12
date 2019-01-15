// String 클래스 사용법 - 기타 메서드
package ch11;


public class Test06 {
  public static void main(String[] args) {
    
    // String 클래스의 스태틱 메서드 활용
    String s1 = String.format("%s님의 나이는 %d입니다.", "홍길동", 20);
    System.out.println(s1);
    
    // 기본 데이터 타입의 값을 문자열로 만들기
    String s2 = String.valueOf(true);
    String s3 = String.valueOf(100);
    String s4 = String.valueOf(100L);
    String s5 = String.valueOf(3.14f);
    String s6 = String.valueOf(3.14);
    String s7 = String.valueOf('가');
    
    System.out.println(s2);
    System.out.println(s3);
    System.out.println(s4);
    System.out.println(s5);
    System.out.println(s6);
    System.out.println(s7);
    
    
    

    
    
    
  }

}
