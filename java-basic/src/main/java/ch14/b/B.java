package ch14.b;

public class B extends A {

  // 오버라이딩 규칙
  // => 메서드 시그니처를 똑같게 해야 한다.
  // => 파라미터의 이름은 상관없다.

  // => 리턴 타입이 다르면 안된다.
  //@Override
  // int m1() {}

  // @Override void m1(long a) {}
  
  @Override public void m2(String a, int b) {}
  
}