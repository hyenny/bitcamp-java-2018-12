package design_pattern.observer.after2;


public class Test01 {
  
  public static void main(String[] agrs) {
    Car car = new Car();
    
    car.start();
    car.run();
    car.stop();
    
    System.out.println("---------------------------------------");
    
    
    // Observer 패턴 적용
    // 1). 상태가 바뀌었을 때 통지할 규칙을 정의한다.
    //    => 클래스의 상태가 바뀌었을 때 다른 클래스에게 통지해야 하는데,
    //       그 방법이 메서드를 호출하는 것이다.
    //    => 즉 통지를 받을 클래스가 가져야할 메서드 규칙을 정의한다.
    //    => CarObserver 인터페이스 정의
    
    // 2). 상태가 바뀔 때마다 다른 클래스에게 통지하는 기능을 추가한다.
    //      => 상태가 바뀌었을 때 등록된 클래스에게 통지할 수 있도록 코드를 추가한다.
    //     => Car 클래스에서 다음 메서드 추가
    //          addObserver(CarObserver) : 옵저버 추가
    //          removeObserver(CarObserver) : 등록된 옵저버 제거
    //           notifyObserver(CarObserver)
    
    // 2). 특정 상태에 있을 때 작업을 수행하는 클래스를 정의한다.
    //    => 상태가 바뀐 클래스에서 규칙에 따라 호출할 수 있도록
    //       약속된 인터페이스를 구현한다.
    //    => CarObserver 인터페이스를 구현한 클래스 정의
    //     => 예) 자동차 안전벨트 점검 옵저버 => SafeBeltCarObserver
    
    // Car 클래스에 기능을 추가해 보자
    // => 옵저버 패턴을 적용하기 전에는 직접 Car 클래스에 코드를 추가하였다.
    // => 옵저버 패턴을 적용한 후에는 Car 클래스가 특정 상태에 놓일 때 작업을 수행하는
    //    클래스를 쉽게 추가할 수 있다.
    
    car.addObserver(new SafeBeltCarObserver());
    car.start();
    car.run();
    car.stop();
    System.out.println("---------------------------------------");
    
    car.addObserver(new EngineOilCarObserver());
    car.start();
    car.run();
    car.stop();
    System.out.println("---------------------------------------");
    
    car.addObserver(new BreakOilCarObserver());
    car.start();
    car.run();
    car.stop();
    System.out.println("---------------------------------------");
    
    car.addObserver(new LightOffCarObserver());
    car.start();
    car.run();
    car.stop();
    System.out.println("---------------------------------------");
    
    car.addObserver(new SunRoofCloseCarObserver());
    car.start();
    car.run();
    car.stop();
    System.out.println("---------------------------------------");
    
    
  }

}
