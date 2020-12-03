package sb.definition;

import fsc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/1 18:35
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definitions-context.xml");

        User isjinhao = beanFactory.getBean("isjinhao-user", User.class);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(isjinhao);
        System.out.println(user);
    }
}
