package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        // Bean 꺼내기
        StatefulService s1 = ac.getBean(StatefulService.class);
        StatefulService s2 = ac.getBean(StatefulService.class);

        // Thread A에서 A 사용자가 10000원을 주문했다고 가정
        int userAPrice = s1.order("userA", 10000);
        // Thread B에서 B 사용자가 20000원을 주문했다고 가정
        int userBPrice = s2.order("userB", 20000);

        // 주문금액 조회 출력해보기
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

        // Thread A: 사용자 A의 주문금액 조회
        // int price = s1.getPrice();
        // 여기서 우리의 기댓값은 10000원이나, 실제로는 20000원이 조회됨
        // ➡️ 다르게 접근하더라도 결국 같은 인스턴스를 사용하기 때문!!
        // System.out.println("price = " + price);

        // 테스트로 확인!
        // Assertions.assertEquals(s1.getPrice(), 20000);
        Assertions.assertNotEquals(userAPrice, userBPrice);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}