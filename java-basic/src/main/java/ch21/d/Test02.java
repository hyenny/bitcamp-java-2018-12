// 예외 던지기 - 리턴 값으로 예외를 보고하는 경우
package ch21.d;

import java.util.ArrayList;

public class Test02 {

  static ArrayList<String> list = new ArrayList<>();
  
  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName(null); // 전학간 학생인 경우 해당 번호의 이름을 null로 설정한다고 가정하자!
    addName(null); // 전학간 학생인 경우 해당 번호의 이름을 null로 설정한다고 가정하자!
    addName("유관순");
    

    // Exception 계열(RuntimeException 제외)의 예외가 발생하는 메서드를 호출할 때는
    // 반드시 예외처리를 해야한다.
    // try ~ catch로 처리하든, throws
    
    try {
      
      for (int i = 0; i < list.size(); i++) {
        String name = getName(i);
        // 예외 상황을 검사하기 위해 getName()의 리턴 값을 확인한다.
        // null이면 예외가 발생했다는 것이다.
        System.out.println(getName(i));
      }
    } catch (Exception e) {
      
    }
    System.out.println(getName(0));
    System.out.println(getName(1));
    System.out.println(getName(2));
    System.out.println(getName(3)); // 예외 발생! catch 블록 실행
    
    System.out.printf("입력된 이름 개수는 %d 입니다.\n", list.size());
    

  }
  
  static void addName(String name) {
    list.add(name);
  }
  
  
  static String getName(int index) {
    if (index < 0 || index >= list.size())
     return null;
    
    // 예외 상황일 때 이 메서드가 리턴하는 null은
    // 일부러 목록에 입력한 null일 수 있다.
    // 즉 예외 상황일 때 리턴하는 값과 정상적인 결과로 리턴하는 값이 같을 수 있다.
    // 이렇게 return 값으로 예외 상황을 알리는 방식은
    // 완전하게 동작하지 못한다.
    // => 그래서 예외 처리 문법이 별도로 등장한 것이다.
    // => 즉 어떤 상황에서 예외가 발생하면 그것을 호출자
    
    return list.get(index);
  }
 

}

 
