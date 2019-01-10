// 클래스, 레퍼런스, 인스턴스
package ch07;



public class Test04 {

  // 클래스
  // => 사용자 정의 데이터 타입
  // => 개발자가 애플리케이션에서 특정 정보를 저장할 목적으로 정의한 메모리 설계도
  
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float avg;
  }


  public static void main(String[] args) {
    // 레퍼런스(reference)
    // => 클래스 설계도에 따라 준비된 메모리의 주소를 담는 변수.
    
    Score s1; // Score 설계도에 따라 준비한 메모리(변수들)의 주소를 저장하는 변수

    s1 = new Score(); // Score 설계도에 따라 메모리(변수들)를 준비시킨다.
    // 그리고 메모리의 주소를 레퍼런스에 저장한다.

    // 물론 다음과 같이 한 줄에 표현할 수도 있다.
    Score s2 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
   

    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 90;
    s2.math = 90;

    // 메서드에 새 데이터 타입으로 만든 메모리의 주소를 전달한다.
    // => 값이 아니라 메모리의 주소를 전달한다! "call by reference"
    printScore(s1);
    printScore(s2);


  }
  // 새 데이터 타입의 메모리
  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.avg = s.sum / 3f;
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.avg);  
  }


}

