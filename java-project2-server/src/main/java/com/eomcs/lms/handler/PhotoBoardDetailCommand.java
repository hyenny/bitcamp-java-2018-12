package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardDetailCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardDetailCommand (PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {

      int no = Integer.parseInt(response.requestString("번호?"));

      PhotoBoard photoBoard = photoBoardDao.findByNo(no);
      response.println(String.format("제목: %s", photoBoard.getTitle()));
      response.println(String.format("작성일: %s", photoBoard.getWriteDate()));
      response.println(String.format("조회수: %s", photoBoard.getHits()));
      response.println(String.format("수업: %s", photoBoard.getLessonNo()));
      response.println("사진파일: ");
      
      List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(no);
      for (PhotoFile file : files) {
        response.println(String.format("> %s", file.getFilePath()));
      }
      
  }

}
