package ch18.f;

public class Sedan extends AbstractCar {
  
  // 그리고 서브 클래스에게 구현하라고 맡겨진 메서드를 정의한다.
  @Override
  public void run() {
    System.out.println("씽씽~ 달린다!");
  }

}
