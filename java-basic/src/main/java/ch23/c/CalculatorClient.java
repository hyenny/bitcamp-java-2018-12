// 계산기 클라이언트 만들기
package ch23.c;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 실행 예:
 *  - 클라이언트가 계산기 서버에 접속한 후 
 *  
 *  계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
 *  계산식을 입력하세요! <== 서버의 응답
 *  예) 23 + 7 <== 서버의 응답
 *  > 23 + 7 <== 사용자의 입력, '>'문자는 클라이언트에서 출력한다.
 *  결과는 30 입니다. <== 서버의 응답
 *  > 23 ^ 7 
 *  ^ 연산자를 지원하지 않습니다. <== 서버의 응답
 *  > ok + yes
 *  식의 형식이 잘못되었습니다. <== 서버의 응답
 *  > quit
 *  안녕히 가세요! <== 서버의 응답
 */
public class CalculatorClient {
  Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    try (Scanner keyboard = new Scanner(System.in)) {
     
      try (Socket socket = new Socket("localhost", 8888);
          // 문자열을 주고 받기 편하도록 오리지널 입출력 스트림 객체에 데코레이터를 붙인다.
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          Scanner in = new Scanner(socket.getInputStream())) {
        
        System.out.println("서버와 연결되었음!");
        
        List<String> response = new LinkedList<>();
        
        while(true) {
          response.add(in.nextLine());
          if(response.equals(""))
            break;
        }
        
        for(String resList : response) {
          System.out.println(resList);
        }
        
        while(true) {
          System.out.print(">");
          String command = keyboard.nextLine();
          out.println(command);
          out.flush();
          
        }
          
        
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }

    
  }
    
  

}
