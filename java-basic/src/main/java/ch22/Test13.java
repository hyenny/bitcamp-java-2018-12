package ch22;

import java.io.File;

public class Test13 {

  public static void main(String[] args) throws Exception {
    // bin의 하위 폴더와 파일을 모두 삭제해야만 bin 폴더를 삭제할 수 있다.
    // => 재귀 호출을 이용할 것

    File dir = new File("bin");

    deleteAll(dir);

    System.out.println("삭제 완료!");

  }

  static void deleteAll(File dir) {
    // 파일의 하위 디렉토리와 파일 목록을 얻는다.
    File[] files = dir.listFiles();
    for (File file : files) {

      if (file.isFile()) {
        file.delete();
      } else {
        deleteAll(file);
      }
    }
    dir.delete();

  }
}
