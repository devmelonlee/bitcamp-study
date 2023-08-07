package eomcs.servlet.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Servlet03.service() 호출됨!");

    HttpSession session = req.getSession();

    // ServletResponse 에는 HTTP 프로톨과 관련된 sendRedirect() 가 없다.
    // HttpServletResponse res2 = (HttpServletResponse) res;
    resp.sendRedirect("/ex01/s2");
  }
}
