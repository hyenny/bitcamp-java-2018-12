package com.mycompany.proj.handler;

import com.mycompany.proj.domain.Member;

public class MemberList {
  static final int LENTH = 100;
  
  Member[] members;
  int size;
  
  
 public MemberList() {
   
   this.members = new Member[LENTH];

  }
  
  public Member[] toArray() {
    //전체 배열의 크기 100이라면,
    //현재 들어있는 항목만 따로 배열을 만들어 리턴한다. 
    Member[] arr = new Member[size];
    int i;
    
    for(i = 0; i< size; i++) {
      arr[i] = members[i];
    }
    
    return arr;
  }
  
  public void add(Member member) {

    members[size] = member;

    size++;
  }

}
