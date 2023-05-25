package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템 "); // 스트링 리터럴
    System.out.println("----------------------------------------");

    System.out.print("번호 : ");
    System.out.println(100);
    
    System.out.printf("이름 : %s ", "홍길동");  // %s 자리에 문자열출력
    System.out.println(); //줄만 바꾼다

    System.out.println("나이 :  " + 20);  // 출력전 20을 문자열로 변경, 합쳐서 하나의 문자열로 전달

    System.out.printf("재직자 : %b\n", true); // \n : 다음줄

    System.out.printf("성별(남자(M), 여자(W)) : %c\n", 'M'); //문자 : ''

    System.out.printf("좌우시력 : %.1f, %.1f\n", 1.5f, 1.2f);
    
  }
}
