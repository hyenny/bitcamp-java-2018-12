// java.io.File 클래스 : 디렉토리 생성
package ch22;

import java.io.File;

public class Test04 {

  public static void main(String[] args) throws Exception {
    
    // 생성할 디렉토리 정보를 준비한다.
    File dir = new File("temp");
    if (dir.mkdir()) {
      System.out.println("디렉토리 생성됨");
    } else {
      System.out.println("디렉토리 생성 못함");
    }
    
    // 존재하지 않는 상위 폴더를 자동으로 생성하는 방법
    // => mkdirs()
    //    
    dir = new File("temp2/ok");
    if (dir.mkdirs()) {
      System.out.println("디렉토리 생성됨");
    } else {
      System.out.println("디렉토리 생성 못함");
    }
    
    
    
    
    

    

  }

}
