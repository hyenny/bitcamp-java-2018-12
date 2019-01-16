// 캡슐화(encapsulation) 필요성
package ch13;

public class Score {
  
  private String name;

  private int kor;
  private int eng;
  private int math;

  protected int sum;
  protected float aver;


  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name; 
  }
  


  public int getKor() {
    return this.kor;
  }

  public void setKor(int kor) {
    if (kor >= 0 && kor <= 100) { //유효한 정수인 경우에만 저장한다.
      this.kor = kor;
      this.compute(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
    }
  }

  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    if (eng >= 0 && eng <= 100) { //유효한 정수인 경우에만 저장한다.
      this.eng = eng;
      this.compute();
    }
  }


  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    if (math >= 0 && math <= 100) { //유효한 정수인 경우에만 저장한다.
      this.math = math;
      this.compute();
    }
  }


  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  // 점수를 변경할 때마다 호출되기 때문에 임의로 호출할 필요가 없다.
  // 따라서 비공개로 만든다.
  // 초보 개발자의 많은 착각!
  // => 필드는 무조건 private, 메서드는 무조건 public으로 해야 한다고 생각한다.
  // => 착각이다. 필드든 메서드든 공개할 것은 공개하고 공개하지 말아야 하는 것은 공개하지 말라.
  // => 기본이 비공개이고, 공개할 것만 공개하라.
  //    이렇게 하는 것이 클래스가 잘못 사용되는 상황을 방지할 수 있다.
  
  // 서브 클래스에서 사용할 수 있도록 접근 범위를 넓힌다.
  protected void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
