package design_pattern.command.after;

// Command 규칙에 따라 동작하는 클래스를 정의한다.

public class MemberListCommand implements Command{

  @Override
  public void execute() {
    System.out.println("회원 목록조회 처리!");
    
  } 

}
