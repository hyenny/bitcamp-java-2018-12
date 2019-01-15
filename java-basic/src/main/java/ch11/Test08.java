// String 클래스 사용법 - 기타 메서드
package ch11;


public class Test08 {
  public static void main(String[] args) {
    StringBuffer b1 = new StringBuffer("Hello");
    StringBuffer b2 = new StringBuffer("Hello");
    
    System.out.println(b1 == b2);
    
    // StringBuffer의 equals()는 값을 비교하는 것이 아니라 인스턴스가 같은지 비교한다.
    // 즉 == 연산자와 똑같다
    System.out.println(b1.equals(b2));
    
    // 어떤 클래스에 equals()가 있나요?
    // => 모든 클래스에 있다.
    
//    // 엥?
//    // => 자바의 모든 클래스는 Object 클래스에 정의된 기능을 상속 받는다.
//          Object를 상속 받지 않을 수 없다.
//          => 따라서 자바의 모든 클래스는 Object 클래스에 정의된 메서드를 사용할 수 있다.
    // Object 클래스에 어떤 메서드가 있나요?
    // => equals() : 인스턴스가 같은지를 비교한다.
    // => toString() : 인스턴스의 클래스명과 해시코드를 리턴한다.
    // => hashCode() : 인스턴스의 해시 코드를 리턴한다.
    // => getClass() : 클래스 정보를 리턴한다.
    // => clone() : 인스턴스를 복제하여 리턴한다.
    // => finalize() : 가비지 컬렉터에 의해 제거되기 전에 호출된다
    // => wait() : 잠시 실행을 멈춘다
          
    
    
    
  
  }

}
