package sb.initialization;

import fsc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author ISJINHAO
 * @date 2020/9/28
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        System.out.println("Spring上下文已经启动");

        User user = applicationContext.getBean(User.class);
        System.out.println(user);

        System.out.println("Spring上下文准备关闭");
        applicationContext.close();
        System.out.println("Spring上下文已经关闭");

    }

    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    public User user() {
        User user = new User();
        user.setName("isjinhao");
        user.setId(100L);
        return user;
    }

}
