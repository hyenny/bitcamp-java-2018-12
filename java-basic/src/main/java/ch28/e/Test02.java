// 애노테이션 프로퍼티

package ch28.e;

import java.lang.annotation.Annotation;

@MyAnnotation // 필수 프로퍼티가 있는 경우 값을 반드시 지정해야 한다.
public class Test02 {
  
  @MyAnnotation(value="okok")
  int a;
  
  @MyAnnotation("okok")
  int b;
  
  @MyAnnotation3
  int g;
  
  public static void main(String[] args) {

    

  }


}
