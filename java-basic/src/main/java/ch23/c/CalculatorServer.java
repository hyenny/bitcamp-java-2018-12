// 계산기 서버 만들기
package ch23.c;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  
 public static void main(String[] args) {
   
   try (Scanner keyboard = new Scanner(System.in);
       ServerSocket serverSocket = new ServerSocket(8888)) {
     
     System.out.println("클라이언트의 연결을 기다리고 있음.");
     
     try (
       Socket socket = serverSocket.accept();
       PrintWriter out = new PrintWriter(socket.getOutputStream());
       Scanner in = new Scanner(socket.getInputStream())) {
       
       System.out.println("클라이언트가 연결됨.");
       
       
       out.println("계산기 서버에 오신 걸 환영합니다!");
       out.println("계산식을 입력하세요!");
       out.println("예) 23 + 7");
       out.println();
       out.flush();

     }
       
     } catch (Exception e) {
       e.printStackTrace();
     }
    
  }
 
 public float compute(int num1, int num2, String op) {
   float sum = 0;
   
   switch(op) {
     case "+":
       sum = num1 + num2;
       break;
     case "-":
       sum = num1 - num2;
       break;
     case "*":
       sum = num1 * num2;
       break;
     case "/":
       sum = num1 / num2;
       break;
     case "%":
       sum = num1 % num2;
       System.out.printf(" %s 연산자를 지원하지 않습니다\n",op);
       default:
   }
   
   return sum;
         
  
   }
   
 

}


