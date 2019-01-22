// Canvas와 Pen을 활용하는 예:
package ch18.e;

public class Test01 {
  public static void main(String[] args) {
    
    // Pen 사용 규칙에 따라 만든 도구 준비
    BallPen153 t1 = new BallPen153();
    MultiPen t2 = new MultiPen();
    
    Canvas c1 = new Canvas(t1);
    Canvas c2 = new Canvas(t2);
    
    t1.press(true);
    c1.render("오호라...펜으로 그린 것!");
    
    c1.setPen(t2);
    
    t2.rotate(Zebra.ON);
    
    c1.render("오호라...펜으로 그린 것!");
  }

}
