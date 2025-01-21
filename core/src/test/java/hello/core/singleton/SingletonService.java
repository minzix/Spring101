package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    // 자기 자신을 static으로 선언해서 딱 1개만 가지고 있도록 하기
    private static final SingletonService INSTANCE = new SingletonService();

    public static SingletonService getInstance() {
        return INSTANCE;
    }
    // 이렇게 막아두려고 했음에도 외부에서 new SingletonService()로
    // 객체를 추가로 생성할 위험을 방지하기 위해서 private 생성자 추가하기
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService SingletonService1 = SingletonService.getInstance();
        SingletonService SingletonService2 = SingletonService.getInstance();

        // 확인을 위한 출력들
        System.out.println("SingletonService1 = " + SingletonService1);
        System.out.println("SingletonService2 = " + SingletonService2);

        // 테스트로 확인
        Assertions.assertEquals(SingletonService1, SingletonService2);
    }
}
