package com.eomcs.lms.dao.mariadb;



import java.sql.Connection;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;


public class MemberDaoImpl implements MemberDao {
  
  Connection con;
  public MemberDaoImpl(Connection con) {
    this.con = con;
  }
  
  @SuppressWarnings("unchecked")
  public List<Member> findAll() {
    
    
  }
  
  public void insert(Member member) {
    
    
  }
  
  public Member findByNo(int no) {
    
    
  }
  
  public int update(Member member) {
    
    
  }
  
  public int delete(int no) {
    
}













