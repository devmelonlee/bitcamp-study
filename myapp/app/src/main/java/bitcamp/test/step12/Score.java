package bitcamp.test.step12;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum; // 외부에서 접근 불가
  float aver;

  // 생성자, 리턴 타입이 없어야 한다. 파라미터 변수를 선언해야한다.
  Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
   // 팩토리 메서드 => 삭제되었따 인스턴스 만들면서 바로 초기화 시켜준다.
  
}
