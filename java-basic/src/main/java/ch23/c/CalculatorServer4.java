// 계산기 서버 만들기 - 소스 코드 리팩토링 2 - 클래스 분리하기
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer4 {
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


