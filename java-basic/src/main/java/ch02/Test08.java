
package ch02;

public class Test08 {

    public static void main(String[] args) {

        System.out.println(true);
        System.out.println(false);
        
//        System.out.println((boolean)1); //자바는 정수 값을 true/false로 형변환할 수 없다
        
        //작은 따옴표(single quote)의 리턴 값은 2바이트 정수 값(UTF-16 코드)이다.
        if('가' == 0xac00) { // == 연산의 결과는 tur/false 이다.
          System.out.println("맞다");
        } else {
          System.out.println("아니다!");
        }
       

    }
    
}




