package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  TransactionManager txManager;

  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao,
      TransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }

  @Override
  public void execute(Response response) throws Exception {
    txManager.beginTransaction();
    try {
      PhotoBoard photoBoard = new PhotoBoard();

      photoBoard.setNum(Integer.parseInt(response.requestString("번호?")));
      photoBoard.setTitle(response.requestString("제목?"));

      response.println("사진 파일:");
      List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(photoBoard.getNum());
      for (PhotoFile file : files) {
        response.println(String.format("> ", file.getFilePath()));
      }
      response.println("");

      response.println("사진은 일부만 변경할 수 없습니다.");
      response.println("전체를 새로 등록해야 합니다.");
      String input = response.requestString("사진을 변경하시겠습니까?(y/N)");
      if (input.equalsIgnoreCase("y")) {

        photoFileDao.deleteByPhotoBoardNo(photoBoard.getNum());

        response.println("사진 파일 변경합니다.");
      } 


      photoBoardDao.update(photoBoard);

      if (photoBoardDao.update(photoBoard) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }

      response.println("변경했습니다.");
      txManager.commit();
    } catch (Exception e) {
      txManager.rollback();
      response.println("변경 중 오류 발생");
    }
  }

}
