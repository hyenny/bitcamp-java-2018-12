// 생성자 - 생성자와 this()
package ch10;

class Monitor10 {

  int bright; // 밝기 (0% ~ 100%)
  int contrast = 50; // 명암 (0% ~ 100%)
  int widthRes; // 해상도 너비
  int heightRes = 1080; // 해상도 높이

  Monitor10() { // 생성자 <== 파라미터를 받지 않는 생성자를 기본 생성자라 부른다.
    this(50, 50, 2560, 1200);
    
    this.bright = 50;
    this.contrast = 50;
    this.widthRes = 2560;
    this.heightRes = 1200;
    System.out.println("Monitor10()");
  }

  Monitor10 (int bright, int contrast) {
    this(bright, contrast, 0, 0);
    System.out.println("Monitor10(int, int)");

  }
  
  Monitor10 (int bright, int contrast, int widthRes, int heightRes) {
    this.bright = bright;
    this.contrast = contrast;
    this.widthRes = widthRes;
    this.heightRes = heightRes;
    System.out.println("Monitor10(int, int, int, int)");

  }


  public void on() {
    // 모니터를 켜면 bright, contrast, widthRes, heightRes 값에 맞춰서 LCD의 불을 밝힌다.
    System.out.println("화면을 출력한다.");
  }

  void display() {
    // 초기화 문장?
    // 변수를 선언할 때 값을 설정하는 것을 초기화 문장이라 부른다.
    System.out.println("---------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("---------------------------");
  }
}

public class Test12 {
  public static void main(String[] args) {
    // 모니터 인스턴스 생성

    // 생성자를 지정할 때 파라미터의 값에 저장된다.
    new Monitor10();
    new Monitor10(50, 50);
    new Monitor10(50, 50, 1920, 1080);
    
    // 파라미터 타입이나 개수가 일치하지 않는 생성자는 호출할 수 없다.
   //new Monitor(50); // 컴파일 오류!





  }

}
