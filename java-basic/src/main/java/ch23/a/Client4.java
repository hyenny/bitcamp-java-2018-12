// 대기열에서 클라이언트 연결 정보를 꺼내 처리하기
package ch23.a;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client4 {
  public static void main(String[] args) throws Exception {
    
    Scanner keyboard = new Scanner(System.in);
    
    // 1). 소켓을 먼저 생성한 후 서버와의 연결을 시도한다.
    Socket socket = new Socket();
    System.out.println("소켓 생성됨");
    
    // 2). 연결할 서버의 주소를 준비한다.
    SocketAddress socketAddress = new InetSocketAddress("localHost", 8888);
    
    // 3). 서버와의 연결을 시도한다.
    // => 타임아웃
    System.out.println("서버와 연결 중...");
    socket.connect(socketAddress, 20000); // timeout : milliseconds 
    System.out.println("서버와 연결되었음!");
    

    

    
    keyboard.nextLine();
    socket.close();
              
        
  }

}
