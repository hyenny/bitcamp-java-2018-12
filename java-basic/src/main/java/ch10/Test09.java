// 생성자 - 기본 생성자(default constructor)
package ch10;

class Monitor7 {
  
  int bright; // 밝기 (0% ~ 100%)
  int contrast = 50; // 명암 (0% ~ 100%)
  int widthRes; // 해상도 너비
  int heightRes = 1080; // 해상도 높이
 
  
 
  
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

public class Test09 {
  public static void main(String[] args) {
    // 모니터 인스턴스 생성
    
    //new Monitor7; // 컴파일 오류!
    
    new Monitor7();
    
  
    


  }

}
