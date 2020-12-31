package ab.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sic.domain.User;

/**
 * @author 01395265
 * @date 2020/12/31
 */
public class ConfigurationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfiguration1.class);
        context.refresh();
        User user = context.getBean(User.class);
        System.out.println(user);
    }

}
