package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE];
  static int length = 0;

  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));
    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    boards[length++] = board;
  }

  public static void printBoards() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");


    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      // Date date = new Date(board.getCreatedDate());

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td \n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    String boardNo = Prompt.inputString("글 번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        System.out.printf("이름: %s\n", board.getTitle());
        System.out.printf("이메일: %s\n", board.getTitle());

        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static void updateBoard() { // added
    String boardNo = Prompt.inputString("글 번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        System.out.printf("이름(%s)? ", board.getTitle());
        board.setTitle(Prompt.inputString(""));
        System.out.printf("내용(%s)? ", board.getContent());
        board.setContent(Prompt.inputString(""));
        System.out.printf("새암호? ");
        board.setPassword(Prompt.inputString(""));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }


  // 암호가 같으면 삭제!
  public static void deleteBoard() {

    int boardNo = Prompt.inputInt("번호? ");
    String pw = Prompt.inputString("암호? ");
    Board
    if (pw.equlas())


    int deletedIndex = indexOf(boardNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      boards[i] = boards[i + 1];

    }
    boards[--length] = null;

  }

  private static int indexOf(int boardNo) {
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }

}
