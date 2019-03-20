// Mybatis와 스프링 연동하기 = Java config 사용하여 연동하기
package ch29.k1;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ch29.k1.dao.BoardDao;
import ch29.k1.vo.Board;

public class Test01 {
  public static void main(String[] args) {
    
    /*
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(
            AppConfig.class, DatabaseConfig.class, MybatisConfig.class);

     */
    
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    
    System.out.println("---------------------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n",
          name, iocContainer.getBean(name).getClass().getName());
    }
    
    System.out.println("---------------------------------------");
    
    BoardDao boardDao = (BoardDao) iocContainer.getBean("boardDao");
    List<Board> list = boardDao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    
    System.out.println("---------------------------------------");
    
    Board board = new Board();
    board.setTitle("제목입니다.");
    board.setContents("내용입니다");
    boardDao.insert(board);
    System.out.println("입력 완료!");
    
    System.out.println("---------------------------------------");
    board = boardDao.findByNo(7);
    System.out.println(board);
    
  }
}

