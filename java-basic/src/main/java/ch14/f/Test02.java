// 다형성 변수의 규칙2 - 형변환
package ch14.f;

public class Test02 {
  public static void main(String[] args) {
    
    A obj = new B();
    obj.m1();
    //obj.m2(); // 컴파일 오류!
    
    // 실제 obj에 B 인스턴스의 주소가 들어 있다 할지라도
    // 직접 B 레퍼런스(obj2)에 저장할 수 없다.
   //B obj2 = obj; // 컴파일 오류!
    
    // 레퍼런스가 가리키는 실제 타입을 그대로 사용하고 싶다면,
    // (obj에 저장된 B 클래스를 그대로 사용하고 싶다면)
    // 형변환하여 사용하라!
    
    B obj2 = (B) obj; //
    
    obj2.m2();
    
    if (obj == obj2) {
      System.out.println("obj == obj2");
    }
    
    // 컴파일러는 속일지라도 JVM은 속일 수 없다.
    A obj3 = new A();
    
    // A타입의 인스턴스를 B 타입의 인스턴스라고 주장하면, 컴파일러는 통과시킨다.
    // 그러나 JVM은 오류를 발생시킨다.
    B obj4 = (B) obj3;  //runtime 예외 발생!
    
    obj3.m1();
    obj4.m2();
    
  }

}
