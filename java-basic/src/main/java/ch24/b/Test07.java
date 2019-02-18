// 스레드 우선순위
package ch24.b;

public class Test07 {

  public static void main(String[] args) {
    
    // 스레드의 우선 순위는 1 ~ 10이다.
    // 기본 우선순위는 5이다.
    
    Thread mainThread =  Thread.currentThread();
    System.out.println(mainThread.getPriority()); //5
   
    
   
  }
  

}

//JVM의 스레드 계층도:
// system(TG)
// => main(TG)
//  => main(T)
