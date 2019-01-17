package ch14.b;

public class C extends A {
// 오버라이딩 전의 메서드를 호출하고 싶다면 super 레퍼런스를 사용하다.
  
  pulbic void m4() {
    this.m1(100);
    this.m2("okok", 100);
    this.m2("haha",200);
  }
  
  public static void main(String[] args) {
    C obj = new 1;
    odj.m4();
  }
}