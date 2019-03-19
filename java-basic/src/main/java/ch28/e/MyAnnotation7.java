package ch28.e;

import java.lang.annotation.Retention;

@Retention(RententionPolicy.RUNTIME)
@Trager(ElecmentType.TYPE)
public @interface MyAnnotation7 {
  String[] value();
}
