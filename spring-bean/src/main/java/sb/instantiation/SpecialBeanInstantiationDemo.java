package sb.instantiation;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sb.holder.UserFactory;
import sb.holder.UserFactoryInterface;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author 01395265
 * @date 2020/9/28
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/special-bean-instantiation-context.xml");
        AutowireCapableBeanFactory capableBeanFactory = applicationContext.getAutowireCapableBeanFactory();

        UserFactory userFactory = capableBeanFactory.createBean(UserFactory.class);
        System.out.println(userFactory.createUserByInstanceMethod());

        ServiceLoader serviceLoader = applicationContext.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);
        System.out.println("---------------------------");
        demoServiceLoader();

    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactoryInterface> serviceLoader = ServiceLoader.load(UserFactoryInterface.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    public static void displayServiceLoader(ServiceLoader serviceLoader) {
        Iterator<UserFactoryInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactoryInterface userFactoryInterface = iterator.next();
            System.out.println(userFactoryInterface.createUserByInstanceMethod());
        }
    }

}