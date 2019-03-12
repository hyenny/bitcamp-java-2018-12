package ch27.c;

import java.lang.reflect.Constructor;

public class Test01 {
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    
    //Class<?> clazz = Student.class;
    Class<?> clazz = Class.forName("ch27.c.Student"); // 위의 코드와 같은 작업을 하다.
    
  
    Student s1 = (Student) clazz.newInstance();
    
    Constructor<Student> c1 = (Constructor<Student>) clazz.getConstructor();
    Student s2 = c1.newInstance();
    
    Constructor<Studernt> c2
  }

}
