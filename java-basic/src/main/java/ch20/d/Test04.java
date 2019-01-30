// HashMap에서 value 목록 꺼내기
package ch20.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Test04 {
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
    
    // value 목록 꺼내기.  value는 중복이 허용되기 때문에 Collection 사용
    Collection<Student> values = map.values(); //  HashMap의 values() 메서드 : 반환형은 Collection<V>이다.
    for (Student value : values) {
      System.out.println(value);
    }
   
    




  }
}


