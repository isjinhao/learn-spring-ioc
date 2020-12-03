package bb.instantiation;

import fsc.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import bb.holder.UserFactory;
import bb.holder.UserFactoryBean;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 01395265
 * @date 2020/9/28
 */
public class BeanFactoryBeanInstantiationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        createByFactoryBean(beanFactory);
        createByInstanceMethod(beanFactory);
        createByStaticMethod(beanFactory);
        Map<String, User> beansOfType = beanFactory.getBeansOfType(User.class);
        beansOfType.values().stream().forEach(System.out::println);
//         我们一共注册了四个Bean：create-by-factory-bean, userFactory, create-by-instance-method, create-by-static-method
        System.out.println(Arrays.deepToString(beanFactory.getSingletonNames()));
        // 可以获取FactoryBean本身，他是一个singleton，但是去除它本身的时候需要使用&+beanName
        System.out.println(beanFactory.getBean("&create-by-factory-bean"));
        System.out.println(beanFactory.getSingleton("create-by-factory-bean"));
        System.out.println(beanFactory.getBean("create-by-factory-bean"));
        // 所以存储的四个Bean是：
        //  create-by-factory-bean -> UserFactoryBean.class
        //  userFactory -> UserFactory.class
        //  create-by-instance-method -> User.class
        //  create-by-static-method -> User.class
    }

    private static void createByFactoryBean(DefaultListableBeanFactory beanFactory) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserFactoryBean.class);
        beanFactory.registerBeanDefinition("create-by-factory-bean", beanDefinitionBuilder.getBeanDefinition());
    }

    private static void createByStaticMethod(DefaultListableBeanFactory beanFactory) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserFactory.class);
        beanDefinitionBuilder.setFactoryMethod("createUserByStaticMethod");
        beanFactory.registerBeanDefinition("create-by-static-method", beanDefinitionBuilder.getBeanDefinition());
    }

    private static void createByInstanceMethod(DefaultListableBeanFactory beanFactory) {
        BeanDefinitionBuilder beanDefinitionBuilder1 = BeanDefinitionBuilder.genericBeanDefinition(UserFactory.class);
        beanFactory.registerBeanDefinition("userFactory", beanDefinitionBuilder1.getBeanDefinition());
        BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder2.setFactoryMethodOnBean("createUserByInstanceMethod", "userFactory");
        beanFactory.registerBeanDefinition("create-by-instance-method", beanDefinitionBuilder2.getBeanDefinition());
    }

}
