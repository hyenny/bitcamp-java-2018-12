// 캡슐화(encapsulation) 필요성
package ch12.b;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  
  // 계산 결과는 조작하지 못하도록 접근을 제한하자!
  private int sum;
  private float aver;
  
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
