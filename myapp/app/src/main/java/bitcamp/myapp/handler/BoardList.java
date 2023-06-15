package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;

public class BoardList {
  private static final int DEFAULT_SIZE = 100;

  private Board[] boards = new Board[DEFAULT_SIZE];
  private int length;

  public void add(Board board) {
    if (this.length == boards.length) {
      increase();
    }

    this.boards[this.length++] = board;
  }

  private void increase() {
    // 기존 배열 보다 50% 큰 배열을 새로 만든다. >> 1 == / 2
    Board[] arr = new Board[boards.length + (boards.length >> 1)];

    // 기존 배열의 값을 새 배열로 복사한다.
    for (int i = 0; i < boards.length; i++) {
      arr[i] = boards[i];
    }

    // boards 레퍼런스가 새 배열을 가리키도록 한다.
    boards = arr;

    System.out.println("배열을 늘렸음!");
  }

  public Board[] List() {
    Board arr = new Board[this.length];

    for (int i = 0; i < this.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  public Board get(int no) {
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];

    }
  }

  public Board get(int no) {
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];

    }
}
