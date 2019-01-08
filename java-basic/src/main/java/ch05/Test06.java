// 흐름제어문 - switch문과 enum

package ch05;

public class Test06 {
  
  // 상수를 정의하는 문법
  static enum UserType {
    MANAGER, MEMBER, GUEST
  }

  public static void main(String[] args) {
    UserType type = UserType.MANAGER;
    
    
    // switch의 조건으로 상수를 의미하는 enum 값이 올 수 있다. 
    switch(type) {
      case MEMBER:
        System.out.println("일반회원입니다.");
        break;
      case MANAGER:
        System.out.println("관리자입니다.");
        break;
      case GUEST:
        System.out.println("손님입니다.");
        break;
      default:
        System.out.println("유효하지 않은 사용자입니다.");
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


