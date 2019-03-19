// 애노테이션 프로퍼티

package ch28.e;

import java.lang.annotation.Annotation;


@MyAnnotation7(
    name="홍길동",
    age = 20;)
public class Test04 {

  public static void main(String[] args) {
    Class<?> clazz = Test04.class; 
    MyAnnotation7 anno1 = clazz.getAnnotation(MyAnnotation7.class);
    MyAnnotation anno2 Test04.class.getAnnotation(MyApplication7.class);
  }


}
