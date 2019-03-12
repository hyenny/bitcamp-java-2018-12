package com.eomcs.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

// DAO 인터페이스의 규칙에 따라 메서드가 호출될 때 실제 작업을 수행할 객체이다.
public class DaoInvocationHandler implements InvocationHandler{

  // SQL을 실행할 때 사용할 SqlSessionFactory를 준비한다.
  SqlSessionFactory sqlSessionFactory;

  public DaoInvocationHandler (SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // DAO 인터페이스의 메서드를 호출할 때마다 이 메서드가 호출될 것이다.
    // 이 메서드에서 할 일은 매퍼 파일에서 적절한 SQL을 찾아 실행하는 것이다. 

    // 1). 실행할 SQL 아이디를 준비하기
    //    SQL 아이디 = 인터페이스명.메서드명
    // => 파라미터로 받은 프록시 객체로부터 인터페이스 이름을 알아낸다.
    String sqlId = String.format("%s.%s",
        proxy.getClass().getInterfaces()[0].getName(), method.getName());

    // 2). 메서드의 리턴 타입
    Class<?> returnType = method.getReturnType();

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      System.out.println(sqlId + "의 SQL을 실행한다.");

      if (returnType == List.class) {
        if (args == null) // 파라미터가 없는 DAO의 메서드를 호출한다면 
          return sqlSession.selectList(sqlId);
        else
          return sqlSession.selectList(sqlId, args[0]);
      } else if (returnType == int.class) {
        if (args == null) 
          return sqlSession.update(sqlId);
        else 
          return sqlSession.update(sqlId, args[0]); // insert(), update(), delete()
      } else {
        if (args == null)
          return sqlSession.selectOne(sqlId);
        else
          return sqlSession.selectOne(sqlId, args[0]);
      }
    }
  }

}
