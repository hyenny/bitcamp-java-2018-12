// Serialize - private 인스턴스 필드의 값 출력 : getter/ setter 있는 경우
package ch22.g;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test02_1 {
  
  public static void main(String[] args) {
    
  
  try(ObjectOutputStream out = new ObjectOutputStream(
      new FileOutputStream("score2.data"))) {
    
    Score2 score = new Score2();
    score.setName("홍길동");
    score.setKor(100);
    score.setEng(100);
    score.setMath(100);
    score.setSum(score.getKor() + score.getEng() + score.getMath());
    score.setAver(score.getSum() / 3f);
    
    // 인스턴스 출력하기
   // => 필드가 접근 범위가 private이라도 상관없이 serialize 된다.
   // => 
   out.writeObject(score);
    
    System.out.println("출력 완료!");
    
    
  } catch (Exception e) {
    e.printStackTrace();
    
  }
  


}
}
