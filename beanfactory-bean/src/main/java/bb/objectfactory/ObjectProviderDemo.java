package bb.objectfactory;

import fsc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author ISJINHAO
 * @Date 2020/12/3 18:38
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "isjinhao");
        beanDefinitionBuilder.setLazyInit(true);
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("aha", beanDefinitionBuilder.getBeanDefinition());
        ObjectProvider<User> objectProvider = beanFactory.getBeanProvider(User.class);
        System.out.println(objectProvider.getObject());
        System.out.println("获得了 ObjectProvider 对象，接下来获得 User 对象");
        System.out.println(objectProvider.getObject());
    }

}
