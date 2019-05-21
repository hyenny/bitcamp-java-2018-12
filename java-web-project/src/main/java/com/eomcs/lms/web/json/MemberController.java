package com.eomcs.lms.web.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@RestController("json/MemberController")
@RequestMapping("/json/member")
public class MemberController {

  @Autowired
  MemberService memberService;
  @Autowired
  ServletContext servletContext;


  @PostMapping("add")
  public Object add(Member member, MultipartFile photoFile) {
    
    System.out.println("회원 : " + member);
    System.out.println("파일 : " + photoFile);
    
    HashMap<String, Object> content = new HashMap<>();
    try {
      
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member/" + filename);
      photoFile.transferTo(new File(uploadDir));
      //photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }
    
    memberService.add(member);
    content.put("status", "success");
    
    } catch (Exception e) {
      content.put("status","fail");
      content.put("message", e.getMessage());
    }

    return content;
  }

  @GetMapping("delete")
  public String delete(@PathVariable int no) throws Exception {

    if (memberService.delete(no) == 0)
      throw new Exception("해당 번호의 회원이 없습니다.");

    return "redirect:../";
  }

  @GetMapping("detail")
  public Object detail(int no) {

    Member member = memberService.get(no);
  
    return member;
  }

  @GetMapping("list")
  public Object list(@RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize, String keyword) throws Exception {

    int rowCount;

    if (pageSize < 3 || pageSize > 8)
      pageSize = 3;

    if (keyword != "") {
      rowCount = memberService.size(keyword);
      System.out.println("검색한 키워드 개수 : " + rowCount);
    } else {
      rowCount = memberService.size(null);
      System.out.println("전체 열 개수: " + rowCount);
    }

    System.out.println(rowCount);


    int totalPage = rowCount / pageSize;
    if (rowCount % pageSize > 0)
      totalPage++;

    if (pageNo < 1)
      pageNo = 1;
    else if (pageNo > totalPage)
      pageNo = totalPage;


    List<Member> members = memberService.list(pageNo, pageSize, keyword);

    HashMap<String, Object> content = new HashMap<>();
    content.put("list", members);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);
    content.put("keyword", keyword);

    return content;

  }

//  @GetMapping("search")
//  public void search(String keyword, Model model) throws Exception {
//
//    List<Member> members = memberService.list(keyword);
//    model.addAttribute("list", members);
//  }

  @PostMapping("update")
  public String update(Member member, Part photoFile) throws Exception {

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    if (memberService.update(member) == 0)
      throw new Exception("해당 번호의 회원이 없습니다.");

    return "redirect:.";
  }
}
