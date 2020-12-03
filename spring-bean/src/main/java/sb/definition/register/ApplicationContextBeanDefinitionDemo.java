package sb.definition.register;

import fsc.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2020/12/1 18:50
 */
public class ApplicationContextBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建 ApplicationContext 容器，GenericApplicationContext实现了BeanDefinitionRegistry
        GenericApplicationContext applicationContext = new GenericApplicationContext();

        registerBeanDefinition(applicationContext, "isjinhao");
        registerBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        System.out.println(beansOfType);
        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * @Author ISJINHAO
     * @Description 将 User 注册到指定的 BeanRegistry 中
     * @Date 2020/12/1 18:50
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