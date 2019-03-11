package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardListCommand extends AbstractCommand {
  
  PhotoBoardDaoImpl photoBoardDao;
  
  public PhotoBoardListCommand(PhotoBoardDaoImpl photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response){
   
      List<PhotoBoard> boards = photoBoardDao.findAll(null);
      
      for (PhotoBoard board : boards) {
        response.println(
            String.format("%3d, %-20s, %s, %d",
                board.getNum(), board.getTitle(), 
                board.getWriteDate(), board.getHits()));
      }
      
  }

}
