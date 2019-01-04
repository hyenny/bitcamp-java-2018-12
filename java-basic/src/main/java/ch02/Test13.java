
package ch02;

import java.util.Date;

//콘솔로 출력하기 - 형식을 갖춰서 날짜 값 출력하
public class Test13 {

    public static void main(String[] args) {
      
      // 현재 날짜 및 시각 정보를 생성한다.
     //java.lang 패키지의 멤버를 사용할 때는 그냥 이름을 지정하면 된다.
      // 그 외 다른 패키지의 멤버를 사용할 때는 반드시 이름을 함께 지정해야 한다.
      Date today = new Date();
      
      // %t[날짜 및 시간 옵션]
      // 날짜 및 시간 옵션
      // Y : 날짜 및 시간 데이터에서 년도를 추출하여 4자리로 표현한다.
      // y : 날짜 및 시간 데이터에서 년도를 추출하여 뒤의 2자리로 표현한다.
      System.out.printf("%1$tY, %1$ty\n", today);
      
      // B : 날짜 및 시간 데이터에서 월을 추출하여 전체 이름으로 표현한다.
      // b : 날짜 및 시간 데이
      System.out.printf("%1$tB, %1$tb\n", today);
     
      // m : 날짜 및 시간 데이터에서 월을 추출하여 2자리 숫자로 표현한다. ex).12, 01
      System.out.printf("%1$tm\n", today);
      
      // d : 날짜 및 시간 데이터에서 일을 추출하여 2자리 숫자로 표현한다. ex).01, 22
      System.out.printf("%1$td %1$te\n", today);
      
      
      
      System.out.printf("%1$tA %1$ta\n", today);
      
      System.out.printf("%1$tH %1$tI\n",today);
      
      System.out.printf("%1$tS",today);
      
      System.out.printf("%1$tH %1$tI\n",today);
      
      
      // p : 오전 오후 출력하기
      System.out.printf("%1$tp\n",today);
      
      System.out.printf("%1$tY"+"-"+"%1$tm"+"-"+"%1$td",today);
      System.out.printf(" ");
      System.out.printf("%1$tH"+":"+"%1$tM"+":"+"%1$tS",today);
      
      

        
        
        
        


        

    }
    
}







