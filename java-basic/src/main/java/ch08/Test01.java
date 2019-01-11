// 인스턴스 필드와 클래스 필드
package ch08;

class My1 {
  // My1 인스턴스(데이터 타입의 값)를 다룰 때 사용할 값이라면 따로 떼어놓지 말고,
  // My1 클래스에 선언하는 것이 사용할 때 편하다.
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";
  
  // 클래스 필드 : 인스턴스를 생성할 때 만드는 변수가 아니라 클래스를 로딩할 때 만듣는 변수.
  // 클래스는 JVM마다 딱 한 번씩 로딩되기 때문에 "클래스 필드"도 딱 한 번만 생성된다. 
  // 그래서 메모리를 절약할 수 있다.
  // => 클래스 필드를 만드는 문법 : 
  
  // new 명령을 실행할 때 힙 메모리에 생성되는 변수이다.
  // 이런 변수를 인스턴스 필드라고 부른다.
  String name;
  int age;
  String userType;
}
public class Test01 {

  public static void main(String[] args) {
    
    My1 obj1 = new My1();
    obj1.name = "홍길동";
    obj1.age = 20;
    obj1.userType = My1.member;
    
    My1 obj2 = new My1();
    obj2.name = "임꺽정";
    obj2.age = 30;
    obj2.userType = My1.manager;
    
    My1 obj3 = new My1();
    obj3.name = "유관순";
    obj3.age = 17;
    obj3.userType = My1.guest;
    
    My1 obj4 = new My1();
    obj4.name = "윤봉길";
    obj4.age = 17;
    obj4.userType = My1.member;
   
  }

}
