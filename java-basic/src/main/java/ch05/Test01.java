package ch05;

public class Test01 {

  public static void main(String[] args) {
    int age = 20;
    
    if (age >= 20) System.out.println("성인입니다.");
    
    //보통 조건 다음에 오는 문장은 다음 줄에 놓는다.
    if (age >= 20)
      System.out.println("성인입니다");
    
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
