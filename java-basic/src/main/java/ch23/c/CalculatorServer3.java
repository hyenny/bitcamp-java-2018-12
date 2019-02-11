// 계산기 서버 만들기 - 소스 코드 리팩토링
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer3 {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행중...");
      while (true) {

        processRequest(serverSocket.accept());

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static void processRequest(Socket socket) {

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

  static void calculate(String request, PrintStream out) {

    try {

      String[] input = request.split(" ");

      int a = Integer.parseInt(input[0]);
      String op = input[1];
      int b = Integer.parseInt(input[2]);
      int result = 0;

      switch (op) {
        case "+":
          result = a + b;
          break;
        case "-":
          result = a - b;
          break;
        case "*":
          result = a * b;
          break;
        case "/":
          result = a / b;
          break;
        case "%":
          result = a % b;
          break;
        default:
          out.printf("%s 연산자를 지원하지 않습니다\n", op);
          out.flush();
          return;
      }

      out.printf("결과는 %d입니다\n", a + b);
      out.flush();

    } catch (Exception e) {
      out.println("식의 형식이 잘못되었습니다.");
      out.flush();
    }

  }
  
  static boolean isQuit(String request, PrintStream out) {
    if (request.equalsIgnoreCase("quit")) {
      out.println("안녕히 가세요!");
      out.flush();
      return true;
    }
    return false;
    
  }


}


