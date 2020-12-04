package bb.other.exception;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author ISJINHAO
 * @Date 2020/12/3 22:08
 */
public class BeanInstantiationExceptionDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册 Bean。CharSequence 是一个接口
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
        beanFactory.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());
        System.out.println(beanFactory.getBean("errorBean"));
    }

}
