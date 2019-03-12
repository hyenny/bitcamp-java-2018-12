package ch27.b;

public class Test01 {

  public static void main(String[] args) {
    
    Class<?> clazz = Calculator.class;
    
    System.out.println(clazz.getName()); // 패키지 이름을 포함한 클래스명
    System.out.println(clazz.getCanonicalName());
    System.out.println(clazz.getSimpleName());
    

  }

}
