// 가비지와 가비지 컬렉터 그리고 레퍼런스 카운트
package ch07;

// 패키지 클래스
// => 단독으로 선언하는 클래스이다.
// => 물론 이 예제처럼 한 파일에 여러 개의 클래스를 선언할 수 있지만,
//    보통은 한 파일에 한 클래스를 선언한다.
// => 패키지 멤버 클래스는 접근 권한이 있다면 누구든 사용할 수 있다.

class Score1 {
  String name; 
  int kor;
  int eng;
  int math;
  int sum;
  float avg;
}

public class Test09 {

  // 중첩 클래스
  // => 클래스 안에 소속된 클래스이다.
  // => 보통 특정 클래스 안에서만 사용될 경우 중첩 클래스로 정의한다.

  // 스태틱 중첩 클래스(static nested class) = top level nested class
  // => 이 클래스를 소유하고 있는 클래스 뿐만 아니라 다른 클래스도 사용할 수 있다.
  static class Score2 {
    String name; 
    int kor;
    int eng;
    int math;
    int sum;
    float avg;
  }

  // 논-스태틱 클래스(non-static nested class) = inner class
  // => 특정 인스턴스에 종속된 클래스인 경우 논-스태틱 중첩 클래스로 정의한다.
  class Score3 {
    String name; 
    int kor;
    int eng;
    int math;
    int sum;
    float avg;
  }

  public static void main(String[] args) throws Exception {

    // 로컬 클래스(local class)
    // => 특정 메서드 안에서만 사용되는 클래스인 경우 로컬 클래스로 정의한다.
    // 
    class Score4 {
      String name; 
      int kor;
      int eng;
      int math;
      int sum;
      float avg;
    }

    // 익명 클래스
    // => 클래스 이름이 없는 중첩 클래스이다.
    // => 딱 한 개의 인스턴스를 생성할 때 사용한다.
    // => 클래스를 정의할 때 수퍼 클래스나 인터페이스를 지정해야 한다.
    // => 클래스를 정의할 때 new 연산자를 사용하여 즉시 인스턴스를 생성해야 한다. 
    Object obj = new Object() {
      String name;
      int age;
    };




    }

    static void m1() {
      // 패키지 멤버는 그 패키지에 소속된 누구라도 사용할 수 있다.
      // 패키지
      Score1 s1 = new Score1();

      // 같은 스태틱 멤버인 스태틱 중첩 클래스를 사용할 수 있다.
      Score2 s2 = new Score2();

      // 스태틱 멤버는 인스턴스 멤버를 사용할 수 없다.
      // Score2 s3 = new Score3(); // 컴파일 오류


    }

  }




