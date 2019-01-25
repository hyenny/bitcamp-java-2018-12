
package ch19.a;

public class Test01 {
  public static void main(String[] args) {
    // public으로 공개된 클래스는 다른 패키지에서 접근 할 수 있다.
    ch19.a.sub.A obj = new ch19.a.sub.A();
    
    // ch19.a.sub.B obj2 = new ch19.a.sub.B(); //컴파일 오류!
  }

}
