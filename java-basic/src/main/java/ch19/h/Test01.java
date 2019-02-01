package ch19.h;

public class Test01 {
  
  // 다음과 같이 추상 메서드가 한 개 있는 인터페이스를 "funtional interface"라고 부른다.
  // => 이런 경우에 람다 문법으로 사용할 수 있다.
  static interface Player {
    void play();
  }
  public static void main(String[] args) {
    // 익명 클래스로 인터페이스 구현하기
    Player p1 = new Player() {
      public void play() {
        System.out.println("테스트1");
      }
    };
    
    p1.play();
    
  }

}
