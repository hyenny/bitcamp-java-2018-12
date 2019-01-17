// 캡슐화(encapsulation) 필요성
package ch14.a;

public class Score {
  protected String name;
  protected int kor;
  protected int eng;
  protected int math;
  
  // 계산 결과는 조작하지 못하도록 접근을 제한하자!
  protected int sum;
  protected float aver;
  
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }
  
  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
