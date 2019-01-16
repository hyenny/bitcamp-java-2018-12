package ch13.b;

import ch13.Score;

public class Score2 extends Score {
  
  private int art;
  private int music;

  
  public void setArt(int art) {
    if (art >= 0 && art <= 100) { //유효한 정수인 경우에만 저장한다.
      this.art = art;
      this.compute2(); // 이 클래스에 새로 추가한 계산 메서드를 호출한다.
    }
  }

  public int getArt() {
    return this.art;

  }
  
  
  public void setMusic(int music) {
    if (music >= 0 && music <= 100) { //유효한 정수인 경우에만 저장한다.
      this.music = music;
      this.compute2(); // 
    }
  }

  public int getMusic() {
    return this.music;

  }
  
  private void compute2() {
    // 기존 계산 메소드를 호출해서 일단 국, 영, 수 세 과목의 합계와 평균을 계산한다.
    this.compute();
    
    this.sum += this.music + this.art;
    this.aver = this.sum / 5f;
  }
  
  
}
