package com.eomcs.lms.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;


@Controller("/member/list")
public class MemberListController implements PageController {

  @Autowired MemberService memberService;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Member> members = memberService.list(null);

    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", members);

    return "/member/list.jsp";
  }
}
