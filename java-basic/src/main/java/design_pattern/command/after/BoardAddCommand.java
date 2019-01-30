package design_pattern.command.after;

// Command 규칙에 따라 동작하는 클래스를 정의한다.

public class BoardAddCommand implements Command{

  @Override
  public void execute() {
    System.out.println("게시물 입력 처리!");
    
  } 

}
