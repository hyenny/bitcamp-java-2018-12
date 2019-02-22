package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  // 어플리케이션이 시작될 때 호출된다.
  void contextInitialized(Map<String, Object> context);
  
  // 어플리케이션이 종료될 대 출력한다.
  void contextDestroyed(Map<String, Object> context);

}
