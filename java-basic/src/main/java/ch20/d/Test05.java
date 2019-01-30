// HashMap에서 Key 목록 꺼내기
package ch20.d;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test05 {
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
    
    // key, value 함께 꺼내기
    Set<Entry<String, Student>> entrySet = map.entrySet(); //Entry : Map에서만 사용할 인터페이스
    for (Entry<String,Student> entry : entrySet) {
      System.out.printf("%s==> %s\n",entry.getKey(), entry.getValue());
    }
   
    




  }
}


