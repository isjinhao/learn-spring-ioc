package ab.dependency.injection;

import sic.domain.City;
import sic.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @Author ISJINHAO
 * @Date 2020/12/6 15:42
 */
public class InjectionMethodDebugDemo {

    @Lazy
    @Autowired
    private void init(User user1, User user2) {
        System.out.println(user1.getClass());
        System.out.println(user2.getClass());
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        applicationContext.register(InjectionMethodDebugDemo.class);

        applicationContext.refresh();

        applicationContext.close();

    }

    @Bean
    public User user() {
        return new User(888L, "jinhao", City.SHENZHEN);
    }

}
