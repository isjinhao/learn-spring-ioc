package bb.instantiation;

import sic.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author 01395265
 * @date 2020/9/28
 */
public class ApplicationContextBeanInstantiationDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");

        applicationContext.refresh();

        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        beansOfType.values().stream().forEach(System.out::println);
        applicationContext.close();

    }

}
