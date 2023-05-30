package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템 "); // 스트링 리터럴
    System.out.println("----------------------------------------");

    // 키보드 스캐너 준비

    Scanner sc = new Scanner(System.in);
    System.out.println("번호? ");
    int no = sc.nextInt();

    System.out.println("이름? ");
    String name = sc.next();

    System.out.println("나이? ");
    int age = sc.nextInt();

    System.out.println("재직중(true / false)? ");
    boolean working = sc.nextBoolean();

    System.out.println("성별(남자 M), (여자 W) ? ");
    String str = sc.next();
    char gender = str.charAt(0);

    System.out.print("시력(왼쪽, 오른쪽) ? ");
    float leftEye = sc.nextFloat();
    float rightEye = sc.nextFloat();

    System.out.println("----------------------------------------------");

    System.out.printf("번호 : %d\n", no);
    System.out.printf("이름 : %s\n", name);
    System.out.printf("나이 : %d\n", age);
    System.out.printf("재직자 : %b\n", working);
    System.out.printf("성별(남자(M), 여자(W)) : %c\n", gender);
    System.out.printf("좌우시력 : %.1f, %.1f\n", leftEye, rightEye);

    /* 
    String[] name = new String[100];
    name[0] = "aaa";
    name[99] = "bbb";
    */
  }
}
