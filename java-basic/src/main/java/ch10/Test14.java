// 생성자 활용 - String 클래스의 생성자 활용
package ch10;

public class Test14 {
  public static void main(String[] args) {
    // String 인스턴스 생성
    String s1 = new String();
    // => 내부적으로 문자의 코드 값을 저장할 char 배열(1.8 버전까지) 
    //    또는 byte 배열(1.9부터부터)을 생성한다.
    // => 생성자에서 넘겨주는 값을 배열에 저장한다.
    // => 만약 생성자에 어무것도 넘려기주지 않으면 빈 배열이 생ㅅ성된다.

    System.out.println(s1);

    char[] chars = {'H', 'E', 'L','L', '0'};
    String s3 = new String(chars); // char배열로 String 인스턴스 생성


    System.out.println(s3);

  }
}

