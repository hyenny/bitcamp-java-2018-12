// 클래스 로딩과 클래스 필드의 생성, Method
package ch08;

class My3 {
  // 클래스 필드 = 스태틱 필드(변수)
  static int sa;
  
  // 인스턴스 필드
  int ia;
}

public class Test03 {

  public static void main(String[] args) {
    // 클래스 필드는 인스턴스를 생성할 필요 없이 클래스 이름으로 바로 사용한다.
    My3.sa = 100;
    
    // 인스턴스 필드는 new 명령을 수행해야지만 생성된다.
    My3 obj1 = new My3();
    My3 obj2 = new My3();
    
    obj1.ia = 200;
    obj2.ia = 300;
    
    // 클래스 이름으로는 인스턴스에 접근할 수 없다.
   //My3.ia = 500; // 컴파일 오류
    
    // 클래스 필드에 접근할 때는 레퍼런스를 통해 접근할 수 있다.
    obj1.sa = 500; // OK!
    // 인스턴스 필드에 sa가 있는지 찾아보고 없으면 obj1의 클래스에서 자동으로 찾는다.
    // 그래서 컴파일 오류를 발생시키지는 않지만,
    // 가능한 이런식으로 사용하지 말라!
    // 다른 개발자가 코드를 읽을 때 인스턴스 필드로 오해할 수 있다.
    // 클래스 필드는 클래스 이름으로 사용하라!
    
    System.out.println(My3.sa);
    
    
   
  }

}

