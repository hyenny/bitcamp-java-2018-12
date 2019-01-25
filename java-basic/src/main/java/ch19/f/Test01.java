// 패키지 멤버 클래스가 불편한 경우를 살펴보자.
package ch19.f;


public class Test01 {

  public static void main(String[] args) {
    ArrayList
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    // list에 들어 있는 값을 배열로 꺼내 보자!
    Object[] arr = list.toArray(LinkedList.FORWARD);
    for (Object obj : arr) {
      System.out.println(obj + ",");
    }
    System.out.println();
    
    Object[] arr2 = list.toArray(LinkedList.REVERSE);
    for (Object obj : arr2) {
      System.out.println(obj + ",");
    }
    System.out.println();
    
    LinkedList list2 = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    Object[] arr3 = list.toArray(LinkedList.REVERSE);
    for (Object obj : arr3) {
      System.out.println(obj + ",");
    }
    System.out.println();
   
    
  }

}
