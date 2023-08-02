package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/member/list")
public class MemberListListener implements Servlet {

  MemberDao memberDao;

  public MemberListListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    prompt.println("---------------------------------------");
    prompt.println("번호, 이름, 이메일");
    prompt.println("---------------------------------------");

    List<Member> list = memberDao.findAll();
    for (Member m : list) {
      prompt.printf("%d, %s, %s\n", m.getNo(), m.getName(), m.getEmail());
    }
  }

}
