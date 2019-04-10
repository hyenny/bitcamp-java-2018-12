package com.eomcs.lms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;


@Controller("/member/detail")
public class MemberDetailController implements PageController{

  @Autowired MemberService memberService;
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    
    // JSP가 사용할 수 있도록 ServletRequest 보관소에 저장해둔다.
    request.setAttribute("member", member);
    
    return "/member/detail.jsp";
  }

}
