// 애플리케이션 예외의 종류 : Exception 계열의 예외 처리
package ch21.c;

import java.util.ArrayList;

public class Test07 {

  public static void main(String[] args)
  // RuntimeException 예외는 굳이 메서드 선언부에 지정할 필요가 없다.
  // 지정하지 않아도 예외가 발생하면 호출자에게 던진다. (보고한다.)
  // 다만 그럼에도 메서드 선언부에 지정하는 이유는
  // 이 메서드를 호출하는 개발자에게 이 메서드에서 어떤 예외가 발생하는지 알려주기 위함이다.
  // 물론 이번 예제에서 main()에 붙이는 것은 아무 의미가 없다.
      throws RuntimeException{

    ArrayList<String> list = new ArrayList<>();

    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");


    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(3)); // 예외 발생


    System.out.println("종료!");





  }

}
