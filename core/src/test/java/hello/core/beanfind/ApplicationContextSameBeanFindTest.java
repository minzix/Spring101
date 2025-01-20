package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(sameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시, 동일한 타입의 Bean이 둘 이상일 때 중복오류가 발생함")
    void findBeanByTypeDuplicate(){
        // MemberRepository bean = ac.getBean(MemberRepository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {ac.getBean(MemberRepository.class);});
    }

    @Test
    @DisplayName("타입으로 조회 시, 동일한 타입의 Bean이 둘 이상이면 Bean 이름을 지정해서 조회하면 됨")
    void findBeanByName(){
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertInstanceOf(MemberRepository.class, bean);
    }

    @Test
    @DisplayName("해당 타입의 여러개의 Bean을 모두 조회하고자 할 때")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + ", value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        Assertions.assertEquals(2, beansOfType.size());
    }

    // 우선 현재 AppConfig에서는 동일 타입인 Bean이 두개 이상인 경우가 없으므로 테스트만을 위한 config를 여기서 하나 생성
    // class 내에서 class를 선언했을 때에는 sameBeanConfig는 ApplicationContextSameBeanFindTest 클래스 내에서만 사용하겠다는 의미임
    @Configuration
    static class sameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
