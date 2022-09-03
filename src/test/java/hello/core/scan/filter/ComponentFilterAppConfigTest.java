package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
//        BeanA beanA = ac.getBean("beanA", BeanA.class);
//        Assertions.assertThat(beanA).isNotNull();

        assertThrows((NoSuchBeanDefinitionException.class), () -> ac.getBean("beanA", BeanA.class));
        assertThrows((NoSuchBeanDefinitionException.class), () -> ac.getBean("beanB", BeanB.class));
    }


    @Configuration
    @ComponentScan(
            includeFilters = @Filter(classes = MyIncludeComponent.class),
            excludeFilters = {
                    @Filter(classes = MyExcludeComponent.class),
                    @Filter(type= FilterType.ASSIGNABLE_TYPE, classes = BeanA.class)
            }

            //includeFilters = @Filter(type= FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            //excludeFilters = @Filter(type= FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig{

    }
}