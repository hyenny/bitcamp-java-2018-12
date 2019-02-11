// Stateful 응용 - 클라잉너트의 계산 결과를 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
Stateful 응용
=> 클라이언트가 서버와 연결되면 연결을 끊기 전까지 계속 유지되기 때문에
   작업 정보
 */

public class CalculatorClient2 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    // 계산 요청을 할 때 연산자와 값만 넘긴다
    // 예) + 2
    // 예) / 3
    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()))) {

      System.out.println("서버와 연결됨! ");

      while (true) {
        System.out.print("> ");
        String input = keyboard.nextLine();

        out.println(input);
        out.flush();

        System.out.println("서버에게 계산 작업을 요청함!");

        String response = in.readLine();
        System.out.println(response);

        if (input.equalsIgnoreCase("quit"))
          break;

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와 연결 끊음!");

    keyboard.close();
  }
}











