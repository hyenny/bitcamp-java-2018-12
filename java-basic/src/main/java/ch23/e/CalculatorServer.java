// Stateless  응용
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorServer {
  
  
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      Map<String, Integer> sessionMap = new HashMap<>();
      sessionMap.put("result", 0);
      
      Map<String, Integer> sessionMap2 = new HashMap<>();
      sessionMap2.put("result", 0);
      
      int result = 0;
      
      
      // 서버의 Stateless 통신 방법에서 클라이언트를 구분하여 각 클라이언트의 계산 결과를 유지하려면?
      // => 커피숍에서는 고객의 쿠폰 포인트를 어떻게 관리할까?
     
      while (true) {
        int id;
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          System.out.println("클라이언트와 연결됨! 요청처리 중...");
          id = Integer.parseInt(in.readLine());

          if (id == 10) {
            sessionMap.put("id", id);
            System.out.println(sessionMap.get("id"));
            
          } else if (id == 20) {
            sessionMap2.put("id", id);
           
          }
                   
          
          System.out.printf("클라이언트 id 저장 : %d\n", id);

          
          
          
          String[] input = in.readLine().split(" ");
          
          int b = 0;
          String op = null;
          
          if (id == 10) {
            result = sessionMap.put("result", result);
          } else if (id == 20) {
            result = sessionMap2.put("result", result);
          }
           
          try { 
            op = input[0];
            b = Integer.parseInt(input[1]);
          } catch (Exception e) {
            out.println("식의 형식이 바르지 않습니다.");
            out.flush();
            continue;
          }
          
          switch (op) {
            case "+": result += b; break;
            case "-": result -= b; break;
            case "*": result *= b; break;
            case "/": result /= b; break;
            case "%": result %= b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          
          out.printf("현재 결과는 %d 입니다.\n", result);
          out.flush();
          
          if (id == 10) {
            result = sessionMap.put("result", result);
          } else if (id == 20) {
            result = sessionMap2.put("result", result);
          }
          
          System.out.printf("세션1 값 : %d\n", sessionMap.get("result"));
          System.out.printf("세션2 값 : %d\n", sessionMap2.get("result"));
          
        } catch (Exception e) {
          // 클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다.
          System.out.println("클라이언트와 통신 중 오류 발생!");
          e.printStackTrace();
        }
        
        System.out.println("클라이언트와 연결 끊음!");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  } //main
  

}
