package sb.definition.destroy;

import fsc.domain.User;
import org.springframework.beans.factory.support.*;
import org.springframework.util.StringUtils;

/**
 * @Author ISJINHAO
 * @Date 2020/12/1 18:30
 */
public class BeanFactoryDestroyBeanDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        registerBeanDefinition(beanFactory, "isjinhao");
        registerBeanDefinition(beanFactory);

        beanFactory.getBeansOfType(User.class);

        beanFactory.destroySingleton("isjinhao");
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
        beanDefinitionBuilder.setDestroyMethodName("destroy");
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