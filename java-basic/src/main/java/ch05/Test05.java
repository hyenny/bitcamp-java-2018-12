// 흐름제어문 - switch문과 문자열

package ch05;

public class Test05 {

  public static void main(String[] args) {
    
    String str = "ok";
    
    
    switch(str) {
      case "ok":
        System.out.println("okok");
        break;
      case "no":
        System.out.println("nono");
        break;
      default:
        System.out.println("????");
    }
    
    
   
        
  }
        
}

/* switch 문법
 * 
 * switch (4바이트 정수 값 또는 문자열) {
 *  case 4바이트 정수값 또는 문자열:
 *      문장1;
 *      문장2;
 *      break;
 *  case xxxx:
 *      문장1;
 *      ...
 *      break;
 *  default:
 *   
 */


