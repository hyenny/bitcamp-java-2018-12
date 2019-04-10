package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {

  MemberDao memberDao;
  
  public MemberServiceImpl(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  // 비즈니스 객체에서 메서드 이름은 가능한 업무 용어를 사용한다. 
  @Override
  public List<Member> list(String keyword) {
    if (keyword == null)
      return memberDao.findAll();
    else
      return memberDao.findByKeyword(keyword);
  
  }

  @Override
  public int add(Member member) {

    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) {

    return memberDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    // 이 메서드도 별로 할 일이 없다.
    // 그냥 DAO를 실행시키고 리턴 값을 그대로 전달한다. 
    return memberDao.update(member);
  }

  @Override
  public int delete(int no) {
    // 이 메서드도 그냥 DAO에 명령을 전달하는 일을 한다.
    // 그래도 항상 Command 객체는 이 Service 객체를 통해서 데이터를 처리해야 한다. 
    return memberDao.delete(no);
  }

  @Override
  public Member get(String email, String password) {
   HashMap<String,Object> paramMap = new HashMap<>();
   paramMap.put("email", email);
   paramMap.put("password", password);
   
   return memberDao.findByEmailPassword(paramMap);
   
  }

}
