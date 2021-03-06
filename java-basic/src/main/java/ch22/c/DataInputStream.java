/
package ch22.c;

import java.io.IOException;
import java.io.InputStream;

// 바이트를 읽어 primitive type의 값을 리턴하는 데코레이터 클래스이다.
//
public class DataInputStream extends InputStream {

  InputStream in;

  public DataInputStream(InputStream in) {
    this.in = in;
  }

  @Override
  public int read() throws IOException {
    return in.read();
  }
  
  public short readShort() throws IOException {
    int value = 0;
    
    value |= (in.read() << 8);
    value |= (in.read());
    
    return (short) value;
    
    
  }
  
  public int readInt() throws IOException {
    int value = 0;
    
    value |= (in.read() << 24);
    value |= (in.read() << 16);
    value |= (in.read() << 8);
    value |= (in.read());
    
    return value;
   
  }
  
  public String readUTF() throws IOException {
    int len = 0;
    len |= in.read() << 8;
    len |= in.read();
    
    byte[] bytes new byte[len];
    in.read(bytes);
  }
  
  
  
  
}
