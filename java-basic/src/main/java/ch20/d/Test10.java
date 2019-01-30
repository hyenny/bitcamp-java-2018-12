// Hashtable에서 value 목록 꺼내기 - elements
package ch20.d;

import java.util.HashMap;

public class Test10 {
  public static void main(String[] args) {
    class Key {
      int major;
      int minor;

      public Key(int major, int minor) {
        this.major = major;
        this.minor = minor;
      }

      @Override
      public String toString() {
        return "Key [major=" + major + ", minor=" + minor + "]";
      }

      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + major;
        result = prime * result + minor;
        return result;
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Key other = (Key) obj;
        if (major != other.major)
          return false;
        if (minor != other.minor)
          return false;
        return true;
      } 
      
      
    }
    
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
    
    
    
    Key k1 = new Key(100, 1);
    Key k2 = new Key(100, 2);
    Key k3 = new Key(100, 3);
    
    HashMap<Key, Student> map = new HashMap<>();
    map.put(k1, new Student("홍길동", 20));
    map.put(k2, new Student("임꺽정", 20));
    map.put(k3, new Student("윤봉길", 30));
    
    System.out.println(map.get(k1));
    
    Key k4 = new Key(100, 2);
    System.out.println(map.get(k4));
    
    System.out.println(k2 == k4);
    System.out.println(k2.hashCode() == k4.hashCode());
    System.out.println(k2.equals(k4));
    
    
    // 저장할 때,
    // => Key 객체의 hashCode() 리턴 값으로 위치를 계산하여 저장한다.
    //

    
  }
}



