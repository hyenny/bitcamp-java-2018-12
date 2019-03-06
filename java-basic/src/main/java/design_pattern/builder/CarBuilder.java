package design_pattern.builder;

public class CarBuilder {
  Body[] bodyList = {
      new Body("비트차체1","소형"),
      new Body("비트차체2","중형"),
      new Body("현대차체1","대형")
  };
  
  Engine[] engineList = {
      new Engine("엔진1", "800", 4, 16),
      new Engine("엔진2", "1500", 4, 16),
      new Engine("엔진3", "1980", 4, 16),
      new Engine("엔진4", "3000", 8, 32),
      
  };
  
  Door[] doorList = {
      new Door("스포츠-앞"),
      new Door("스포츠-뒤"),
      new Door("SUV-앞"),
      new Door("SUV-뒤")      
  };

  public Car build(String carModel) {
    switch (carModel) {
      case "비트자동차 모델1":
        Car car = new Car(bodyList[0], engineList[1]);
        car.addDoor(doorList[0]);
        return car;
      case "비트자동차 모델2":
        car = new Car(bodyList[2], engineList[3]);
        car.addDoor(doorList[2]);
        car.addDoor(doorList[2]);
        car.addDoor(doorList[3]);
        car.addDoor(doorList[3]);
        return car;
        default:
          throw new RuntimeException("유효한 모델명이 아닙니다.");
    }
    
  };
}
