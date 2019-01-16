package ch13.a;

import ch13.Score;

public class Test02 {

  public static void main(String[] args) {
    
    // Score2를 이용해 수퍼 클래스의 기능을 호출할 수 있다.
    Score2 s = new Score2();
    s.setName("홍길동");
    s.setKor(100); // Score의 메서드
    s.setEng(100); // Score의 메서드
    s.setMath(100); // Score의 메서드
    s.setMusic(100); // Score2의 메서드
    s.setArt(100); // Score2의 메서드
    
    System.out.printf("%s: %d(%.1f)\n", s.getName(), s.getSum(), s.getAver());

  }

}
