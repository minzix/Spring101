package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    // 스프링에 등록된 모든 빈 정보를 출력
    void findAllBeans() {
        // 스프링에 등록된 모든 빈 이름을 조회
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // 타입을 지정하지 않았으므로 빈을 하나 꺼내면 Object로 받아야 함
            // 빈 이름으로 빈 객체(인스턴스)를 조회
            Object bean = ac.getBean(beanDefinitionName);
            // soutv로 찍으면 바로 변수명을 함께 로그로 프린트해줌 (soutm은 메소드명)
            System.out.println("beanDefinitionName = " + beanDefinitionName);
            System.out.println("bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    // ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
    // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
    void findApplicationBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // 빈의 메타데이터 정보를 꺼내서 저장
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // 애플리케이션 빈 (개발자가 직접 등록한 빈)일 때만 출력
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName);
                System.out.println("bean = " + bean);
            }
        }
    }
}
