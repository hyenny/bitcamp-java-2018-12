// 서브 인터페이스 구현 - 수퍼 인터페이스의 메서드까지 모두 구현해야 한다.
package ch18.d;

// 수퍼 인터페이스가 있는 인터페이스를 구현할 때는
// 수퍼 인터페이스의 메서드까지 모두 구현해야 한다.
public class Tool2 implements ProtocolC {

  @Override
  public void m3() {}

  @Override
  public void m1() {}

  @Override
  public void m2() {}

  @Override
  public void k1() {}

  @Override
  public void k2() {}

  @Override
  public void x() {}
   
  @Override
  public void y() {}

 
}
