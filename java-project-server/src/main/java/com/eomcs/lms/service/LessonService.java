
package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.domain.Lesson;

public class LessonService extends AbstractService<Lesson> {

  public void execute(String request) throws Exception {

    switch (request) {
      case "/lesson/add":
        add();
        break;
      case "/lesson/list":
        list();
        break;
      case "/lesson/detail":
        detail();
        break;
      case "/lesson/update":
        update();
        break;
      case "/lesson/delete":
        delete();
        break;
      default:
        out.writeUTF("FAIL");
    }
    out.flush();
  }


}
