//
package ch23.a;

import java.net.Socket;
import java.util.Scanner;

public class Client2 {
  public static void main(String[] args) throws Exception {
    
    Scanner keyboard = new Scanner(System.in);
    Socket socket = new Socket("localHost", 8888);
    
    System.out.println("서버와 연결되었음!");
    

    
    keyboard.nextLine();
    socket.close();
              
        
  }

}
