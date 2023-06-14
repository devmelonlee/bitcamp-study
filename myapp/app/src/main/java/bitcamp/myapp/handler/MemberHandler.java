package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberHandler {

  private static final int MAX_SIZE = 100;
  // variable initializer(변수 초기화 문장) => static 블록으로 이동
  // 단, final 변수는 static 블록에서 값을 할당하지 않고 그냥상수로 취급한다.

  private Prompt prompt;

  private Member[] members = new Member[MAX_SIZE];
  // variable initializer(변수 초기화 문장) => 생성자로 이동
  private int length;

  // 생성자 : 인스턴스를 사용할 수 있도록 유효한 값으로 초기화 시키는 일을한다.
  // => 필요한 값을 외부에서 받고 싶으면 파라미터를 선언하라.
  public MemberHandler(Prompt prompt) {
    // 어차피 여기로 컴파일러가 생성자를 생성해준다.
    this.prompt = prompt;
  }

  public void inputMember() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0)); // 기본값 : 0, 명시적 형변환

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[this.length++] = m;
  }

  public void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  public void viewMember() {
    String memberNo = prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) { // 인스턴스를 쓰고 있지 않으면 static 붙이기
    return gender == 'M' ? "남성" : "여성";
  }

  public void updateMember() { // added
    String memberNo = prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
        m.setEmail(this.prompt.inputString("이메일(%s)? ", m.getEmail()));
        m.setPassword(this.prompt.inputString("새암호? "));
        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별:\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = this.prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public void deleteMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
      // no[i] = no[i + 1];
      // name[i] = name[i + 1];
      // email[i] = email[i + 1];
      // password[i] = password[i + 1];
      // gender[i] = gender[i + 1];
    }
    this.members[--length] = null;
    // no[length - 1] = 0;
    // name[length - 1] = null;
    // email[length - 1] = null;
    // password[length - 1] = null;
    // gender[length - 1] = (char) 0;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }
  // }
  // System.out.println("해당 번호의 회원이 없습니다.");
  // if (deletedIndex == -1) {
  // System.out.println("해당 번호의 회원이 없습니다.");
  // }

  // if (memberNo < length) {

  // for (int i = memberNo -1; i < length; i++) { //하나씩 뒤로 옮기기
  // name[i] = name[i+1];
  // email[i] = email[i+1];
  // gender[i] = gender[i+1];

  // if (memberNo == length) { // 마지막 노드 삭제
  // name[memberNo - 1] = " ";
  // email[memberNo - 1] = " ";
  // gender[memberNo - 1] = " ";
  // length--;
  // System.out.println("마지막 노드 삭제 완료");
  // return;
  // }

  // }
  // System.out.println("해당 번호의 회원이 없습니다!");

  private boolean available() {
    return this.length < MAX_SIZE;
  }

}
