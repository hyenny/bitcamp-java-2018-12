// HashMap에서 Key 목록 꺼내기
package ch20.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test08 {
  public static void main(String[] args) {
    class Student {
      String name;
      int age;

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }


    }
    
    HashMap<String, Student> map = new HashMap<>();
    
    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정", 30));
    map.put("ccc", new Student("안중근", 25));
    
    Set<String> keySet = map.keySet();
    
    // Set에서 값을 꺼내기 위해 Iterator의 도움을 받는다.
    Iterator<String> iterator = keySet.iterator();
    
    System.out.println(iterator.next());
    map.put("bbb", new )
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    
    
   
    




  }
}

/*
 * HashMap과 Hashtable의 비교
 * 항목                                 HashMap         Hashtable
 * ----------------------------------------------------------
 * 1). Key, value, null 허용       |    Yes        |     No
 * 2). Thread-safe               |    No         |    Yes
 * 3). 실행 속도                       |   속도 빠름      |  속도 느림
 * 4). 고수준의 동기화 처리             |    No         |   ConcurrentHashMap 사용을 권장한다.
 */

