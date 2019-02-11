package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class CalculatorProcessor {
  Socket socket;
  
  public CalculatorProcessor(Socket socket) throws Exception {
    this.socket = socket;
    this.in = new BufferedReader ()
        new InputStreamReader(socket.getInputStream()));
  }
  
  public void execute() {
    
    BufferedReader in = null;
    PrintStream out = null;

    Socket socket = null;

    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());

      out.println("계산기 서버에 오신 걸 환영합니다!");
      out.println("계산식을 입력하세요!");
      out.println(("예) 23 + 7"));
      out.println();

      while (true) {
        String request = in.readLine();
        
        if (isQuit(request, out))
          break;
        
        calculate(request, out);
        
      }
      
    } catch (Exception e) {

    } finally {
      try {
        in.close();
      } catch (Exception e) {
      }
      try {
        out.close();
      } catch (Exception e) {
      }
      try {
        socket.close();
      } catch (Exception e) {
      }
    }

    
  }

}
