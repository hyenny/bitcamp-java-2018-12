package ch22;

import java.io.File;

public class Test14 {

  public static void main(String[] args) throws Exception {
    // 클래스 이름을 출력할 때 출력 형식은 패키지 이름을 포함해야 한다.
    // 예) ch01.Test01
    // 예) ch22.a.Test14
    //

    File cls = new File("bin/main");

    findClass(cls, "");

    System.out.println("출력 완료!");

  }

  static void findClass(File cls, String packageName) {
    // 파일의 하위 디렉토리와 파일 목록을 얻는다.
    File[] files = cls.listFiles(pathname ->
      pathname.isDirectory() ||
      (pathname.isFile() && pathname.getName().endsWith(".class")) ?
        true : false);

    for (File file : files) {
      if (file.isFile()) {
        System.out.printf("%s%s\n", packageName,
            file.getName().replace(".class", ""));
      } else {
        findClass(file, packageName + file.getName() + ".");
      }
    }
    //dir.delete();

  }
}
