// 계산기 서버 만들기
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행중...");
      while (true) {
        Socket socket = null;
        BufferedReader in = null;
        PrintStream out = null;

        try {
          socket = serverSocket.accept();
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          out = new PrintStream(socket.getOutputStream());

          String[] input = in.readLine().split(" ");

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
              continue;
          }

          out.printf("결과는 %d입니다\n", a + b);
          out.flush();

        } catch (Exception e) {
          try {
            out.println("식의 형식이 잘못되었습니다.");
            out.flush();

          } catch (Exception e2) {

          }

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



    } catch (Exception e) {

    }



  }



}


