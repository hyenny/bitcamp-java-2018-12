package ch05;

public class Test03 {

  public static void main(String[] args) {
    int age = 70;
    
    // 기본 형식
    if (age < 8) 
      System.out.println("유아입니다.");
    else {
      if(age >= 8 && age <14)
        System.out.println("어린이입니다");
      else {
        if(age >= 14 && age <65)
          System.out.println("성인입니다");
        else {
          System.out.println("노인입니다");
        }
      }
    }
    
 // 변형
    if (age < 8) 
      System.out.println("유아입니다.");
    else 
      if(age >= 8 && age <14)
        System.out.println("어린이입니다");
      else 
        if(age >= 14 && age <65)
          System.out.println("성인입니다");
        else 
          System.out.println("노인입니다");
    
    if (age < 8) 
     System.out.println("유아입니다.");
    else if(age >= 8 && age <14)
      System.out.println("어린이입니다");
    else if(age >= 14 && age <65)
      System.out.println("성인입니다");
    else 
      System.out.println("노인입니다");
    
    // 결론!
    // => if ~ else if ~ else if ~else 문법은 없다.
    // => 오직 if ~else 문법만 있을 뿐이다. 
    
    age = 17;
    if(age > 19)
      if(age > 65)
        System.out.println("노인입니다");
      else
        System.out.println("미성년입니다");
    
    //들여쓰기에 속지 말라
    
        
  }
    
      
    
    
}


