package design_pattern.singleton;

// 인스턴스를 딱 한 개만 생성하여 공유하고 싶다면,
// Singleton 설계 방식으로 클래스를 정의하라.

class Car2 {
  String model;
  int cc;
  
  // 인스턴스 주소를 받을 클래스 필드를 선언한다.
  static Car2 instance;

  // 1) 생성자를 정의하고 private로 선언하여 비공개로 만들어라.
  // => 비공개 생성자는 외부에서 호출할 수 없다.
  // => 오직 내부에서만 호출할 수 있다.
  private Car2() { 
  }
  
  public static Car2 getInstance() {
    if(Car2.instance == null) {
      Car2.instance = new Car2();
    }
    
    return Car2.instance;
  }
}
public class Test02 {
  public static void main(String[] args) {
    
    // 생성자가 존재하지만 private으로 비공개되어 있기 때문에 직접 호출할 수 없다.
    // 생성자를 호출할 수 없으면 인스턴스를 형성할 수 없다.
    // => 다른 메서드를 호출하여 인스턴스를 생성하라는 의미다.
   //Car2 c1 = new Car2();
    
    // 인스턴스를 생성해주는 메서드를 통해 인스턴스를 얻는다.
    Car2 c2 = Car2.getInstance();
    Car2 c3 = Car2.getInstance();
    
    if(c2 != c3)
      System.out.println("다르다.");
    else
      System.out.println("같다");
    
  }

}
