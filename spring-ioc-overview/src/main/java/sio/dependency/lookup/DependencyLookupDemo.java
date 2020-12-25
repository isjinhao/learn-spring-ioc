package sio.dependency.lookup;

import org.springframework.context.ApplicationContext;
import sic.domain.SuperUserAnnotation;
import sic.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookupDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupRealTimeByName(applicationContext);
        System.out.println("-----------------------");
        lookupLazyByName(applicationContext);
        System.out.println("-----------------------");
        lookupByType(applicationContext);
        System.out.println("-----------------------");
        lookupCollectionByType(applicationContext);
        System.out.println("-----------------------");
        lookupByAnnotation(applicationContext);

    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(SuperUserAnnotation.class);
            System.out.println("查找标注 @SuperUserAnnotation 所有的 User 集合对象：" + users);
        }

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }

    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("loadByType: " + user);
    }

    private static void lookupLazyByName(BeanFactory beanFactory) {
        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactoryUser");
        User user = userObjectFactory.getObject();
        System.out.println("lazyLoadByName: " + user);
    }

    private static void lookupRealTimeByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("realTimeLoadByName: " + user);
    }


}
