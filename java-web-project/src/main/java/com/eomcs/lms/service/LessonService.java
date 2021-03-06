package com.eomcs.lms.service;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Lesson;

public interface LessonService {
  List<Lesson> list(int pageNo, int pageSize, String keyword);
  int add(Lesson lesson);
  Lesson get(int no);
  int update(Lesson lesson);
  int delete(int no);
  int size(String keyword);
}