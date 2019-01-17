package ch13.c;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
    
    // B인스턴스를 이용하여 B가 사용권을 획득한 A 클래스의 메서드를 호출할 수 있다.
    obj.m1();
    obj.m2();
    
    // 실험:
    // bin/main/.../A.class 파일을 제거한 후 다시 Test01을 실행하라.
    // => 결과는? A 클래스가 없다고 예외가 발생한다.
    // => 의미?
    //      상속받는다는 것은 수퍼 클래스의 코드를 그래도 복제해 온다는 것이 아니다.
    //      그냥 수퍼 클래스의 코드를 사용할 수 있는 권한을 획득한다는 것이다.
    //      그래서 수퍼 클래스

  }

}
