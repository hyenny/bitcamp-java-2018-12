// reflection API - 메서드의 상세정보 꺼내기
package ch27.b;

import java.lang.reflect.Method;


public class Test05 {

  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = String.class;
    
    Method[] methods = clazz.getDeclaredMethods();
    for (Method m : methods) {
      System.out.printf("메서드명: %s\n", m.getName());
      System.out.println("파라미터:");
      java.lang.reflect.Parameter[] params = m.getParameters();
      for (java.lang.reflect.Parameter p : params) {
        System.out.printf("    %s:%s\n",
            p.getName(),
            p.getType().getName());
      }
      
      System.out.println("리턴 타입:");
      System.out.printf("   %s\n", m.getReturnType().getName());
      
      System.out.println("접근 제어:");
      int modifiers = m.getModifiers();

      System.out.println("---------------------------");
    }
    
    


  }

}
