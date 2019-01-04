package ch03;

public class Test07 {

    public static void main(String[] args) {
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
  
      System.out.println("a?:");
      int a = keyboard.nextInt();
      // nextInt()는 한 개의 토큰(token)을 읽을 때까지 기다린다.
      // 한 개의 토큰을 읽으면 4바이트 정수 값으로 바꾼 다음에 리턴한다.
      // 토큰(token)?
      // => 토큰이란 공백으로 구분되는 단어를 뜻한다.
      // 공백(whitespace)?
      // => 스페이스(space), 탭, 줄바꿈 코드를 말한다.
      // 예) aaa bbb
      
      System.out.println("b?:");
      int b = keyboard.nextInt();
      //java.lang 패키지의 멤버를 사용할 때는 패키지 이름을 적지 않아도 된다.
      
      //사용자가 입력한 문자열을 출력한다.
      System.out.printf("%d * %d = %d\n",a,b,a*b);
                                                                                                                                                                                                                  
    }      
}   
