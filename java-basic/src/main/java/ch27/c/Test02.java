package ch27.c;

import java.lang.reflect.Method;

public class Test02 {
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    
    Student s1 = new Student("홍길동", "hong@test.com", true, 25);
    
    Method m1 = s1.getClass().getMethod("setName", String.class);
    m1.invoke(obj, args);
  }

}
