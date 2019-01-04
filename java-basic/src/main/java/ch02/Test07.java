// 키보드로 입력한 값을 받
package ch02;

public class Test07 {

    public static void main(String[] args) {
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
  
      System.out.println("이름을 입력하세요:");
      java.lang.String name = keyboard.nextLine();
      
      System.out.println("나이을 입력하세요:");
      java.lang.String age = keyboard.nextLine();
      
      //사용자가 입력한 문자열을 출력한다.
      System.out.printf("당신의 이름은 %s 입니다\n", name);
      System.out.printf("당신의 나이는                                                                                                                                                                                                                            %s 입니다\n", age);
     
    
    }      
}   

