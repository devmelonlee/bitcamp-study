package coding.ex001;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test2 {
  public static void main(String[] args) {




      // BiFunction<T, U, R> 인터페이스
      // => R apply(T, U);
      //
      // Map.put(키, 값)
      // => 키 : Character
      // => 값 : Integer
      // => 예) put('x', 100);
      //
      // Map.compute(키, 값을 리턴할 객체)
      // => 키 : K
      // => 값을 리턴할 객체 : BiFunction<? super K, ? super V, ? extends V>
      //


    class MyValue imnplements BiFunction<Character, Integer, Member> {
      @Override
      public Integer apply(Character key, Integer value) {
        // 이 메서드는 Map.compute() 호출한다.
        // 파라미터로 넘어 오는 것은 기존에 저장된 키와 값이다.
        // 해당 키의 값이 없다면 null이 넘어온다.

        if (value == null) {
          return 1;
        }

        return value + 1;
      }
    }
    MyValue 값생성기 = new MyValue();

    String str = "Be strong, be fearless, be beautiful. "
        + "And believe that anything is possible when you have the right "
        + "people there to support you. ";

    Map<Character, Integer> result = new HashMap<>();

    for (char ch : str.toCharArray()) {
    result.compute(ch, 값생성기)
    }

    for (Entry<Character, Integer) entry : result.entrySet() {
      System.out.printf("%c: %d:\n", entry.getKey(), entry.getValue());
    }

  }
}
