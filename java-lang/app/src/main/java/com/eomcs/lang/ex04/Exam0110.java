package com.eomcs.lang.ex04;

// # 변수(variables)
// - 값을 저장하는 메모리
//
// # 변수 선언
// - 값을 저장하는 메모리를 준비하는 명령이다.
// - 값을 저장할 메모리의 종류와 크기를 결정하고 그 메모리에 이름을 부여한다.
// - 변수를 선언한 후 바로 그 이름을 사용하여 메모리에 접근하고 값을 넣고 꺼낸다.
// - 보통 "변수를 생성한다"라고 표현하기도 한다.
// - 문법
//     메모리의종류 메모리이름;
//     int a;
//
public class Exam0110 {
  public static void main(String[] args) {

    // 변수 선언 문법
    // - 데이터타입 변수
    //
    /*int i;*/

    // 문법
    // - int : 값을 저장할 메모리의 종류. '데이터 타입(data type; 자료형)'이라 부른다.
    // - i : 메모리를 가리키는 이름. '변수(variables)'라 부른다.
    //
    // 의미
    // - 정수 값을 담을 메모리를 준비하고 그 메모리의 이름을 i 라고 하자!

  }
}

// ## 변수의 이름
// - 보통 소문자로 시작한다.
// - 대소문자를 구분한다.
// - 여러 단어로 구성된 경우 두 번째 단어의 시작 알파벳은 대문자로 한다.
// - 예) firstName, createdDate, userId
// - 상수인 경우 보통 모두 대문자로 이름을 짓는다. 단어와 단어 사이는 _를 사용한다.
// - 예) USER_TYPE, USER_MANAGER
