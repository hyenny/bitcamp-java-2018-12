package ch05;

public class Test02 {

  public static void main(String[] args) {
    int age = 22;
    
    // 기본 형식
    if (age >= 20) 
      System.out.println("성인입니다.");
    else 
      System.out.println("미성년입니다.");
    
    //보통 조건 다음에 오는 문장은 다음 줄에 놓는다.
    // 대부분의 자바 개발자들은 if ~ else 의 모양을 K & R 모양으로 작성한다.
    if (age >= 20) {
      System.out.println("------------------");
      System.out.println("성인입니다");
    } else {
      System.out.println("------------------");
      System.out.println("미성년입니다.");
    }
    
    // if문만 작성할 수 있지만 else 문만 존재할 수 없다~!
      
      
    
    if (age >= 20) {
      System.out.print("성인");
      System.out.println("입니다");
    }
    
    System.out.println("------------------");
    
    if (age >= 20)
      System.out.print("성인");
      System.out.println("입니다"); // 주의! 이 문장은 if문에 종속되지 않는다.
      
    
    
  }

}
