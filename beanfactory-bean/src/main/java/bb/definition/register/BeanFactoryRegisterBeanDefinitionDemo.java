package bb.definition.register;

import fsc.domain.User;
import org.springframework.beans.factory.support.*;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2020/12/1 18:30
 */
public class BeanFactoryRegisterBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        registerBeanDefinition(beanFactory, "isjinhao");
        registerBeanDefinition(beanFactory);

        Map<String, User> beansOfType = beanFactory.getBeansOfType(User.class);
        System.out.println(beansOfType);
    }

    /**
     * @Author ISJINHAO
     * @Description 将 User 注册到指定的 BeanRegistry 中
     * @Date 2020/12/1 18:34
     * @Param
     * @return
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "isjinhao");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 没有BeanName的时候也可以使用BeanDefinitionReaderUtils.registerWithGeneratedName方法。
        // 这个方法底层还是调用的BeanDefinitionReaderUtils.generateBeanName
        if (!StringUtils.hasText(beanName)) {
            beanName = BeanDefinitionReaderUtils.generateBeanName(beanDefinition, registry, false);
        }
        registry.registerBeanDefinition(beanName, beanDefinition);
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null);
    }

}