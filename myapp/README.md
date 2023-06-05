# 실습 프로젝트

## 1. 자바 프로젝트 준비하기

- Gradle 빌드 도구를 이용하여 프로젝트를 구성하는 방법
  - `init` task 실행
- Gradle로 프로젝트를 빌드하고 실행하는 방법
  - `build`, `run` task 실행
  - `gradle -q run`

## 2. 리터럴을 사용하여 데이터 출력하기

- 리터럴을 사용하는 방법

## 3. 변수를 사용하여 데이터를 저장하기

- 변수를 사용하는 방법

## 4. 키보드로 값을 입력 받기

- 키보드로 값을 입력 받는 방법

## 5. 배열과 반복문을 이용하여 여러 개의 데이터를 입력 받기

- 배열 활용
- 반복문 활용
- 상수 활용

## 6. 조건문을 활용하여 실행 흐름을 제어하기

- if ~ else ~ 조건문 활용
- switch 활용
- break 활용 
- while 활용

### 10일(6/5,월)

- 자바 프로그래밍
  - 클래스 사용법
    - 클래스 문법의 목적
    - 클래스의 public 접근 제어
    - 메서드의 public 접근 제어
  - 패키지 사용법
    - import를 이용하여 패키지를 미리 지정하기
- 프로젝트 실습
  - 8. 메서드 간에 변수 공유하기 : 스태틱 변수 사용법(계속)
    - 리팩토링: 메서드 추가 정의, 상수 선언
  - 9. 메서드를 역할에 따라 분류하기 : 클래스 및 패키지 사용법
- 과제(개인)
  - 개인 프로젝트 수행
    - 프로젝트 폴더 생성 및 초기화
    - 실습 프로젝트와 마찬가지로 1단계에서 9단계까지 진행
    - 각 단계별로 app 폴더를 백업할 것.


### 11일(6/7,수)

- 과제(개인) 발표
  - 개인 프로젝트 시연
  - 프로그래머스 일별 점수 보고
    - 6/5(점수), 6/6(점수) 
  - github.com 잔디 확인
    - 개인별 github.com 의 bitcamp-study 저장소 주소 제출
      - 이름, url
    - to: jinyoung.eom@gmail.com


---


### 쉘 실행
- /c/Users/bitcamp/git/bitcamp-study/myapp/app

### 컴파일
- javac -d bin/main src/main/java/bitcamp/myapp/App.java -encoding UTF8
- gradle compileJava

### 빌드
- java -cp bin/main bitcamp.myapp.App
