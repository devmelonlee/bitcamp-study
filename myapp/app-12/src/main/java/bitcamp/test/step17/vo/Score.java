package bitcamp.test.step17.vo;

public class Score {

  // 직접 접근을 허용했을 때, 무효한 값을 저장할 수 있기 때문에
  // private으로 접근을 막는다.
  private String name;
  private int kor; // 일관성있게 막았다
  private int eng;
  private int math;
  private int sum; // 외부에서 접근 불가, 필요에 의해서
  private float aver;

  // 생성자, 리턴 타입이 없어야 한다. 파라미터 변수를 선언해야한다.
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.setKor(kor);
    this.setEng(eng);
    this.setMath(math);
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

  public int getKor() {
    return this.kor;
  }

  public void setKor(int kor) {
    if (kor < 0 || kor > 100) {
      return;
    }
    this.kor = kor;
    this.compute();
  }

  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    if (eng < 0 || eng > 100) {
      return;
    }
    this.eng = eng;
    this.compute();
  }

  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    if (math < 0 || math > 100) {
      return;
    }
    this.math = math;
    this.compute();
  }
}
