package ch28.c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 애노테이션 사용 범위

@Target(ElementType.LOCAL_VARIABLE)
public @interface MyAnnotation4 {

}
