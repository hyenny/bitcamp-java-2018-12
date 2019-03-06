// 빌더 패턴 : 여러 개의 객체를 조립하여 한 객체를 생성할 때 사용하는 방법
// 
package design_pattern.builder;

public class Test {

  public static void main(String[] args) {
    CarBuilder carBuilder = new CarBuilder();
    Car c1 = carBuilder.build("비트자동차 모델1");
    System.out.println(c1);
    System.out.println("---------------------------------");
    
    Car c2 = carBuilder.build("비트자동차 모델2");
    System.out.println(c1);
    System.out.println("---------------------------------");
    
    Car c3 = carBuilder.build("비트자동차 모델3");
    System.out.println(c1);
    System.out.println("---------------------------------");
    
    
  
  }

}
