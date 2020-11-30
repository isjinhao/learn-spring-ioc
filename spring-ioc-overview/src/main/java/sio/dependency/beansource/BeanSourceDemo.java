package sio.dependency.beansource;

import sio.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class BeanSourceDemo {

    public static void main(String[] args) {

        /**
         * BeanFactory是Spring的底层IOC容器
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory);

        System.out.println(userRepository.getApplicationContext());

//        System.out.println(beanFactory.getBean(BeanFactory.class));
        System.out.println(userRepository);


        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取内置的bean对象" + environment);

    }

}
