// java.util.ArrayList 사용법 - indexOf
package ch20.a;

import java.util.ArrayList;
import java.util.Date;

public class Test03 {
  public static void main(String[] args) {
    
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    
    String s4 = new String("bbb");
    
    System.out.println(s2 == s4);
    System.out.println(s2.equals(s4));
    System.out.println(s2.hashCode() == s4.hashCode());
    
    
    
    ArrayList<String> list = new ArrayList<>();
    
    list.add(s1);
    list.add(s2);
    list.add(s3);
    
    System.out.println(list);
    
    // contains() : 
    //  => 인스턴스가 다르더라도 equals()의 리턴 값이 true라면
    //     같은 값이 목록에 있는 것으로 판단한다.
    // => Student 클래스에서 equals()를 오버라이딩 하지 않는다면
    //     list.contains(s4)의 리턴 값은 false가 될 것이다.
    System.out.println(list.contains(s2));
    System.out.println(list.contains(s4));
    
    
  
  }

}
