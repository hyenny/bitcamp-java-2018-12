// 스레드 그룹의 부모 스레드 그룹
package ch24.b;

public class Test05 {

  public static void main(String[] args) {
    
    // 스레드 그룹에 소속된 하위 스레드 그룹 목록을 알아내기
    //
    Thread currThread =  Thread.currentThread();
    ThreadGroup group = currThread.getThreadGroup();
    ThreadGroup parentGroup = group.getParent();
    
    // "main" 스레드 그룹의 부모 스레드 그룹은?
    System.out.println(parentGroup.getName() + "(TG)");
    
    // "system" 스레드 그룹의 부모 스레드 그룹은?
    ThreadGroup parentParentGroup = parentGroup.getParent();
    System.out.println(parentParentGroup); //null. system의 상위 스레드 그룹은 없다.
    
  }

}

//JVM의 스레드 계층도:
// system(TG)
// => main(TG)
//  => main(T)