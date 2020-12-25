package ab.order;

import org.springframework.beans.BeansException;
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
public class  BeanFactoryProcessorOrderedDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"META-INF/bean-beanfactory-order-context.xml"}, false, null);

        applicationContext.refresh();
        applicationContext.close();
    }

    static class MyBeanFactoryPostProcessor1 implements BeanDefinitionRegistryPostProcessor, Ordered {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("BeanFactoryPostProcessor order 0");
        }
        @Override
        public int getOrder() {
            return 0;
        }
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("BeanDefinitionRegistryPostProcessor order 0");
        }
    }

    static class MyBeanFactoryPostProcessor2 implements BeanDefinitionRegistryPostProcessor, Ordered {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("BeanFactoryPostProcessor order 1");
        }
        @Override
        public int getOrder() {
            return 1;
        }
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("BeanDefinitionRegistryPostProcessor order 1");
        }
    }

    static class MyBeanFactoryPostProcessor3 implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("BeanFactoryPostProcessor priority 0");
        }
        @Override
        public int getOrder() {
            return 0;
        }
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("BeanDefinitionRegistryPostProcessor priority 0");
        }
    }

    static class MyBeanFactoryPostProcessor4 implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("BeanFactoryPostProcessor priority 1");
        }
        @Override
        public int getOrder() {
            return 1;
        }
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("BeanDefinitionRegistryPostProcessor priority 1");
        }
    }

    static class MyBeanFactoryPostProcessor5 implements BeanDefinitionRegistryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("BeanFactoryPostProcessor no order");
        }
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            System.out.println("BeanDefinitionRegistryPostProcessor no order");
        }
    }

}
