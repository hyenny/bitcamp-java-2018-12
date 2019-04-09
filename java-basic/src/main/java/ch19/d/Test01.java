package ch19.d;

public class Test01 {
  
  public static void main(String[] args) {
    Product p = new Product();
    p.maker = "비트컴퓨터";
    p.title = "비트마우스";
    p.price = 98000;
    
    // 상수를 Category 클래스로 옮긴 후에 사용하기
    p.category = Category.COMPUTER_MOUSE;
    
    
    
  }

}
