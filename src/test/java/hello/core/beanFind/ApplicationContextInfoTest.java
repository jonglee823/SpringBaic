package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("All bean")
    void findAllBean(){
        String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for(String beanDefinition : beanDefinitionNames){
            Object bean = ac.getBean(beanDefinition);
            System.out.println("name : " + beanDefinition + " Object : " + bean);
        }
    }

    @Test
    @DisplayName("application bean")
    void findApplicationBean(){
        String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name : " + beanDefinitionName + " Object : " + bean);
            }
        }
    }
}
