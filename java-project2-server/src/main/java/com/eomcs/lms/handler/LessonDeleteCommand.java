package com.eomcs.lms.handler;



import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.domain.PhotoBoard;


public class LessonDeleteCommand extends AbstractCommand {

  LessonDaoImpl lessonDao;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public LessonDeleteCommand(
      LessonDaoImpl lessonDao, 
      PhotoBoardDao photoBoardDao, 
      PhotoFileDao photoFileDao) {
    this.lessonDao = lessonDao;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }


  @Override
  public void execute(Response response) throws Exception {
    int no = Integer.parseInt(response.requestString("번호?"));
    
    HashMap<String, Object> params = new HashMap<>();
    params.put("lessonNo", no);
    
    List<PhotoBoard> boards = photoBoardDao.findAll(params);
    for (PhotoBoard board : boards) {
      photoFileDao.deleteByPhotoBoardNo(board.getNum());
      photoBoardDao.delete(board.getNum());
    }


    lessonDao.delete(no);
    response.println("삭제했습니다.");
  }
}
