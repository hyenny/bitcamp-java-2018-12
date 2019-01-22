// 다중 인터페이스를 구현하지 못하는 경우 - 메서드명과 파라미터는 같은데 리턴 타입이 다른 경우
package ch18.c;


public class Tool implements ProtocolA, ProtocolB, ProtocolC {
  
  // 여러 규칙을 모두 만족시키려면
  // 여러 규칙의 모든 메서드를 구현해야 한다.
  
  // ProtocolA 규칙에 따라 동작할 수 있도록 메서드를 구현

  @Override
  public void m1() {
    System.out.println("Tool.m1()");
    
  }

  // 다음 메서드는 ProtocolA 규칙은 만족시키지만, ProtocolC 규칙은 만족시키지 못한다.
  @Override
  public void m2() {
    // TODO Auto-generated method stub
    System.out.println("Tool.m2()"); 
  }
  
  // 그럼 리턴 값이 다른 메서드를 만들면 되지 않나요?
  // => 오버로딩 규칙에 따라 파라미터와 메서드명은 같고 리턴 값이 다른 메서드를 여러 개 만들 수 없다.
  @Override
  public int m2() {
    // TODO Auto-generated method stub
    System.out.println("Tool.m2()");
    
  }
  

  
  @Override
  public void m3() {
    // TODO Auto-generated method stub
    System.out.println("Tool.m3()");
    
  }
  

  
 

}
