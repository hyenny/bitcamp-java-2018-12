// HashMap에서 Key 목록 꺼내기
package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Test03 {
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
    map.put("bbb", new Student("안중근", 25));
    
    // key 목록 꺼내기. key는 중복되어서는 안되기 때문에 Set을 사용
    Set<String> keySet = map.keySet(); // HashMap의 keySet() 메서드 : 반환형은 Set<K>이다.
    for (String key : keySet) {
      System.out.printf("%s=> %s\n", key, map.get(key));
    }
   
    




  }
}


