package bb.other;

import sic.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author ISJINHAO
 * @Date 2020/12/4 17:03
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 演示按名称查找Bean的安全性
        displayBeanFactoryGetBeanByName(beanFactory, "isjinhao");

        // 演示 BeanFactory#getBean 方法的安全性
        displayBeanFactoryGetBean(beanFactory);

        // 演示 ObjectFactory#getObject 方法的安全性
        displayObjectFactoryGetObject(beanFactory);

        // 演示 ObjectProvider#getIfAvaiable 方法的安全性
        displayObjectProviderIfAvailable(beanFactory);

        // 演示 ListableBeanFactory#getBeansOfType 方法的安全性
        displayListableBeanFactoryGetBeansOfType(beanFactory);

        // 演示 ObjectProvider Stream 操作的安全性
        displayObjectProviderStreamOps(beanFactory);

    }

    private static void displayBeanFactoryGetBeanByName(BeanFactory beanFactory, String beanName) {
        printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(beanName));
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
    }

    private static void displayObjectFactoryGetObject(DefaultListableBeanFactory beanFactory) {
        // ObjectProvider is ObjectFactory
        ObjectFactory<User> userObjectFactory = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", () -> userObjectFactory.getObject());
    }

    private static void displayObjectProviderIfAvailable(DefaultListableBeanFactory beanFactory) {
        ObjectProvider<User> userObjectProvider = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectProviderIfAvailable", () -> userObjectProvider.getIfAvailable());
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderStreamOps(BeanFactory beanFactory) {
        ObjectProvider<User> userObjectProvider = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps", () -> userObjectProvider.forEach(System.out::println));
    }

    private static void printBeansException(String source, Runnable runnable) {
        System.err.println("Source from :" + source);
        try {
            runnable.run();
            System.out.println("");
        } catch (BeansException exception) {
            exception.printStackTrace();
        }
        System.err.println("==========================================\n\n\n");
    }

}