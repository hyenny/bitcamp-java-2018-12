package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// 계산기 서버 만들기 - 1단계: 단순히 클라이언트 요청에 응답하기

public class CalculatorServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("서버 연결 중...");

      while (true) {
        Socket socket = null;
        BufferedReader in = null;;
        PrintStream out = null;

        try {
          socket = serverSocket.accept();
          in = new BufferedReader(new InputStreamReader((socket.getInputStream())));
          out = new PrintStream(socket.getOutputStream());
          
          String request = in.readLine();      
          if(request.equalsIgnoreCase("quit")) {
            out.println("안녕히 가세요!");
            out.flush();
            break;
          }
          
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
              out.printf("%s 연산자를 지원하지 않습니다", op);
              out.flush();
              continue;
          }

          out.printf("결과는 %d 입니다", result);
          out.flush();

        } catch (Exception e) {
          try {
          out.println("식의 형식이 잘못되었습니다.");
          out.flush();
          } catch (Exception e1) {
            e.printStackTrace();
          }
        } finally {
          try {
            socket.close();
          } catch (Exception e1) {
          }
          try {
            in.close();
          } catch (Exception e2) {
          }
          try {
            out.close();
          } catch (Exception e3) {
          }

        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}


