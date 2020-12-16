package ab.order;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 21:10
 */
public class BeanProcessorOrderedDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"META-INF/bean-bean-order-context.xml"}, false, null);
        applicationContext.refresh();

        System.out.println("refresh finish!");

        System.out.println(applicationContext.getBean("test-user"));

        applicationContext.close();
    }

    static class MyBeanPostProcessor1 implements BeanPostProcessor, Ordered {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("order 0  " + beanName);
            return bean;
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    static class MyBeanPostProcessor2 implements BeanPostProcessor, Ordered {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("order 1  " + beanName);
            return bean;
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }

    static class MyBeanPostProcessor3 implements BeanPostProcessor, PriorityOrdered {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("priority 0  " + beanName);
            return bean;
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    static class MyBeanPostProcessor4 implements BeanPostProcessor, PriorityOrdered {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("priority 1  " + beanName);
            return bean;
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }

    static class MyBeanPostProcessor5 implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("no order  " + beanName);
            return bean;
        }
    }

}
