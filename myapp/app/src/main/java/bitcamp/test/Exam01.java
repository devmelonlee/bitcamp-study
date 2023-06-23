package bitcamp.test;

// 클래스가 로딩될 때 만들어진다
// 클래스는 언제? 실행될때

class A {
  static int v1 = 111; // 1. 인스턴스변수 만든 후 클래스 실행, 스태틱 블록 안으로 차례대 들어간다.

  // int v2 = 100;
  int v3 = 200;

  { // 인스턴스 블록
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
  }

  public A() {
    System.out.println("444");
  }

  public A(int a) {
    System.out.println("555");
  }

  public A(int a, int b) {
    System.out.println("666");
  }


  static { // 스태틱 블록은 클래스가 로딩되면 실행된다.
    // 한번 실행되면 두번 실행되지 않는다.
    // 한 클래스에 스태틱 블록은 1개만 만들어야함~!
    System.out.println("A클래스의 스태틱 블록 실행!");
    v1 = 200;
    v2 = 300;
  }
  static int v2 = 222;
  // -> 실행 결과 : v1 : 200, v2 : 222;

  static void m1() {}

}


public class Exam01 {

  public static void main(String[] args) {
    A obj; // 레퍼런스 변수를 선언할 때는 클래스 로딩 안됨

    // A.v1 = 100;
    // A.m1();
    new A();
    new A();
    new A();

    // obj = new A(); //
    // Class clazz; // 클래스의 class : cls, clz, clazz로 쓴다.
    try {
      Class.forName("bitcamp.test.A"); // fully-qualified name : FQname, QName : 남이만든 클래스
      // 클래스를 못찾으면 null을 리턴하는것이 아닌 예외를 던진다.
      System.out.println("트라이함");
    } catch (ClassNotFoundException e) {
      System.out.println("클래스 못찾네!");
    }
  }
}
