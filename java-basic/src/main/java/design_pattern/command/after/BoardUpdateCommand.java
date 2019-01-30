package design_pattern.command.after;

public class BoardUpdateCommand implements Command {
  
  @Override
  public void execute() {
    System.out.println("게시물 갱신 처리!");
    
  } 

}
