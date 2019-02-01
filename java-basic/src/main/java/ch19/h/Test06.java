// Lamda 문법 - 람다 파라미터
package ch19.h;

public class Test06 {
  
  static interface Player {
    void play();
  }
  
  static interface Player2 {
    // 인터페이스도 static 메서드를 가질 수 있다.
    static String info() {
      return "Player2입니다";
    }
    
    // 인터페이스는 디폴트 메서드를 가질 수 있다.
    // => 기존 프로젝트에 영향을 끼치지 않으면서 기존 규칙에 새 메서드를 추가할 때 사용한다.
    default void stop() {
      // 어차피 새 메서드는 새 프로젝트의 구현체가 오버라이딩 할 것이니 여기에서는 자세하게 정의하지 않는다.
    }
    
    // 인터페이스에 static 메서드나 default 메서드가 여러 개 있더라도
    // 그 메서드들은 이미 구현된 메서드이기 때문에 추상 메서드와 상관없다.
    // 따라서 이 인터페이스는 추상 메서드가 한 개이다.
    // 즉 람다로 구현할 수 있다.
    void play();
  }
  
  
  public static void main(String[] args) {
    
    Player p1 = () -> System.out.println("Player...");
    p1.play();
    
    // static 메서드나 default 메서드가 몇 개이든 그 개수는 중요하지 않다.
    // 단 추상 메서드가 한 개이어야 한다
    // 그러면 다음과 같이 람다 문법으로 사용할 수 있다.
    Player p2 = () -> System.out.println("Player2...");
    p2.play();
    System.out.println(Player2.info());
    
    // 추상 메서드가 두 개 이상인 경우 람다 문법을 사용할 수 없다.
    //Player3 p3 = () -> System.out.println("Player3...");
  }

}
