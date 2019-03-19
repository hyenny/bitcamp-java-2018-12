package ch28.d;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 애노테이션 반복 사용
// => 기본은 한 선언에 대해 한 번만 사용을 허가한다.
@Repeatable(ElementType.TYPE) 
public @interface MyAnnotation {

}
