package bitcamp.util;

public class Calculator {
    // non-static 필드는 new 명령어를 실행해야만 heap 영역에 생성된다.
    private int result = 0; // 인스턴스 변수임!!!~

    public int getResult() { // c에 저장되어있는 위치
        return this.result;
    }
  
    public void init(int a) {
        this.result = a; //인스턴스 변수에 접근
    }
    
    public void plus(int a) {
        this.result += a;
    }
  
    public void minus(int a) {
        this.result -= a;
    }
  
    public void multiple(int a) {
        this.result *= a;
    }
  
    public void divide(int a) {
        this.result /= a;
    }

}
