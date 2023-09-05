package bitcamp.myapp.controller;

import bitcamp.myapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/")
public class HomeController implements PageController {
  @Autowired
  MemberService memberService;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/WEB-INF/jsp/index.jsp";
  }
}
