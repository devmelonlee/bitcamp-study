<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ page import="bitcamp.myapp.vo.AttachedFile"%>
<%@ page import="bitcamp.myapp.vo.Board"%>

<jsp:useBean id="boardDao" type="bitcamp.myapp.dao.BoardDao" scope="application"/>
<jsp:useBean id="sqlSessionFactory" type="org.apache.ibatis.session.SqlSessionFactory" scope="application"/>
<%
    request.setAttribute("refresh", "2;url=list.jsp?category=" + request.getParameter("category"));
    Board board = boardDao.findBy(
        Integer.parseInt(request.getParameter("category"),
        Integer.parseInt(request.getParameter("no"));
    pageContext.setAttribute("board", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시글</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>게시글</h1>

<%
    if (board == null) {
%>
<p>해당 번호의 게시글이 없습니다!</p>
<%
    } else {
%>
<form action='/board/update.jsp' method='post' enctype='multipart/form-data'>
<input type='hidden' name='category' value='${board.category}'>
<table border='1'>
<tr><th style='width:120px;'>번호</th>
<td style='width:300px;'><input type='text' name='no' value='${board.no}' readonly></td></tr>
<tr><th>제목</th>
<td><input type='text' name='title' value='${board.title}'></td></tr>
<tr><th>내용</th>
<td><textarea name='content' style='height:200px; width:400px;'>${board.content()}</textarea></td></tr>
<tr><th>작성자</th> <td>${board.writer()name()}</td></tr>
<tr><th>조회수</th> <td>${board.viewCount()}</td></tr>
<tr><th>등록일</th> <td>${String.format("%tY-%1$tm-%1$td", board.getCreatedDate())%></td></tr>
<tr><th>첨부파일</th><td>

<%
      for (AttachedFile file : board.getAttachedFiles()) {
%>
<a href='https://kr.object.ncloudstorage.com/bitcamp-nc7-bucket-08/board/${file.filePath}'>${file.filePath}</a>
[<a href='/board/fileDelete.jsp?category=${category}&no=${file.no}'>삭제</a>]
<br>
<%
      }
%>
<input type='file' name='files' multiple>
</td></tr>
</table>

<div>
<button>변경</button>
<button type='reset'>초기화</button>
<a href='/board/delete.jsp?category=${board.category()}&no=${board.no()}'>삭제</a>
<a href='/board/list.jsp?category=${board.category()}'>목록</a>
</div>
</form>
<%
      try {
        board.setViewCount(board.getViewCount() + 1);
        boardDao.updateCount(board);
        sqlSessionFactory.openSession(false).commit();

      } catch (Exception e) {
        sqlSessionFactory.openSession(false).rollback();
      }
    }
%>

<jsp:include page="../footer.jsp"/>

</body>
</html>













