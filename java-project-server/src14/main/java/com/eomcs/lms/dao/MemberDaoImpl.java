// 데이터 처리 관련 코드를 별도의 클래스로 분리
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl extends AbstractDao<Member> {

  public MemberDaoImpl(String filepath) {
    this.filepath = filepath;
  }
  
  public void insert(Member member) {
    list.add(member);
  }

  public List<Member> findAll() {
    return list;
  }

  public Member findByNo(int no) {
    for (Member obj : list) {
      if (obj.getNum() == no) {
        return obj;
      }
    }
    return null;
  }

  public int update(Member member) {
    int index = 0;
    for (Member obj : list) {
      if (obj.getNum() == member.getNum()) {
        list.set(index, member);
        return 1;
      }
      index++;
    }
    return 0;
  }

  public int delete(int no) {
    int index = 0;
    for (Member obj : list) {
      if (obj.getNum() == no) {
        list.remove(index);
        return 1;
      }
      index++;
    }
    return 0;
  }

}







