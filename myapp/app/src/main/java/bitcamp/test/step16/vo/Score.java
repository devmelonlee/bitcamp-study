package bitcamp.test.step16.vo;

public class Score {
  public String name;
  public int kor; // 일관성있게 막았다
  public int eng;
  public int math;
  private int sum; // 외부에서 접근 불가, 필요에 의해서
  public float aver;

  // 생성자, 리턴 타입이 없어야 한다. 파라미터 변수를 선언해야한다.
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
  // 팩토리 메서드 => 삭제되었따 인스턴스 만들면서 바로 초기화 시켜준다.

  // getter : private 으로 접근이 막힌 변수의 값을 리턴해주는 메서드
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  public String getName() {
    return this.name;
  }
}
