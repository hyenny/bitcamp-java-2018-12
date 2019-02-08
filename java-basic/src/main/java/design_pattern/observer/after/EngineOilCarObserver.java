package design_pattern.observer.after;

public class EngineOilCarObserver implements CarObserver {

  @Override
  public void carStarted() {
    // TODO Auto-generated method stub
    System.out.println("엔진 오일 ");
    
  }

  @Override
  public void carStopped() {
    // TODO Auto-generated method stub
    
  }

}
