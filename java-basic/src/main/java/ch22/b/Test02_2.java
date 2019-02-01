package ch22.b;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test02_2 {

  public static void main(String[] args) {
    
    byte[] buf = new byte[1024];
    
    int count = in.read(buf);
    
    for (int i = 0; i <count ; i++) {
      System.out.println(Integer.toHexString(buf[i]) + " ");
    }
  }

}
