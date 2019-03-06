package design_pattern.builder;

import java.util.ArrayList;
import design_pattern.builder.Body;
import design_pattern.builder.Door;
import design_pattern.builder.Engine;

public class Car {
  Body body;
  Engine engine;
  ArrayList<Door> doors = new ArrayList<>();
  
  public Car(Body body, Engine engine) {
    super();
    this.body = body;
    this.engine = engine;
  }
  
  public void addDoor(Door door) {
    doors.add(door);
  }

  @Override
  public String toString() {
    return "Car [body=" + body + ", engine=" + engine + ", doors=" + doors + "]";
  }
  
  
  
  
  

}
