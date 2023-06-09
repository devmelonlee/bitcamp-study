package bitcamp.test.step14;

import bitcamp.test.step14.vo.Score;

// 1) 낱개의 변수 사용
// 2) 낱개의 변수 재사용
// 3) 배열 사용
// 4) 클래스를 이용하여 데이터 타입 정의(중첩클래스; 로컬 클래스)
// 5) 출력 기능을 별도의 메서드로 분리(중첩클래스; 스태틱 중첩 클래스) 
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴: Information Expert(정보를 갖고 있는 클래스가 그 정보를 다룬다.)
// 8) 인스턴스 메서드 도입
// 9) 객체 생성이 복잡한 경우 메서드로 분리하는 것이 낫다. (디자인 패턴 : 팩토리 메서드)
// 10) GRASP 패턴: Information Expert 을 create 로 이동
// 11) 생성자 도입 : 인스턴스 변수를 보다 쉽게 초기화 시키기
// 12) 변수의 접근을 제어하기 : private/public, getter/setter
// 12) 클래스를 유지하기 쉽게 별도의 파일로 분리
// 13) 클래스를 유지보수하기 쉽게 패키지로 분류
// 14) 외부접근 차단과 값꺼내기 : private/public, getter/setter

public class App {
  
  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    //  new Score(문자열, int, int, int);
    //  => score 설계도에 따라 인스턴스를 생성하라
    //  => 생성한 후 string, int, int, int 파라미터 값을 받는 생성자를 호출하라
    //  => 이렇게 초기화시킨 인스턴스의 주소를 리턴하라.

    scores[length++] = new Score("홍길동", 100, 100, 100);
    scores[length++] = new Score("임꺽정", 90, 90, 90);
    scores[length++] = new Score("유관순", 80, 80, 80);

    //이렇게 접근하는 걸 막을 수 없다. -> private로 바꾸면 꺼낼 수도 없다.
    //scores[0].sum = 20000;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }

  }
 

  static void printScore(Score s) {
    System.out.printf("%s: 합계=%d, 평균=%.1f\n", 
      s.name, s.getSum(), s.getAver());
  }

}
