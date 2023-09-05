package bitcamp.myapp.controller;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.myapp.service.NcpObjectStorageService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.ArrayList;

@Controller("/board/update")
public class BoardUpdateController implements PageController {

  @Autowired
  BoardService boardService;

  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  @Override
  public String execute(HttpServletRequest request, HttpServletRequest response) throws Exception {
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      request.getParts(); // 일단 클라이언트가 보낸 파일을 읽는다. 그래야 응답 가능!
      return "redirect:../auth/login";
    }



    try {

      Board board = boardService.get(Integer.parseInt(request.getParameter()));
      int count = boardDao.update(board);
      if (count > 0 && board.getAttachedFiles().size() > 0)

      ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
      for (Part part : request.getParts()) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("tx1");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);

        if (part.getName().equals("files") && part.getSize() > 0) {
          String uploadFileUrl = ncpObjectStorageService.uploadFile(
                  "bitcamp-nc7-bucket-08", "board/", part);
          AttachedFile attachedFile = new AttachedFile();
          attachedFile.setFilePath(uploadFileUrl);
          attachedFiles.add(attachedFile);
        }
      }
      board.setAttachedFiles(attachedFiles);

      if (boardDao.update(board) == 0) {
        throw new Exception("게시글이 없거나 변경 권한이 없습니다.");
      } else {
        if (attachedFiles.size() > 0) {
          boardDao.insertFiles(board);
        }
        txManager.commit(status);
        return "redirect:list?category=" + request.getParameter("category");
      }

    } catch (Exception e) {
      txManager.commit(status);
      request.setAttribute("refresh", "2;url=detail?category=" + request.getParameter("category") +
              "&no=" + request.getParameter("no"));
      throw e;
    }
  }
}











