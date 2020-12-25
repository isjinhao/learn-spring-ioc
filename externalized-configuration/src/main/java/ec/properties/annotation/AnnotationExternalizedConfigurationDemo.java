package ec.properties.annotation;

import sic.domain.City;
import sic.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author ISJINHAO
 * @Date 2020/12/16 10:45
 */
@PropertySource("classpath:META-INF/user.properties")
public class AnnotationExternalizedConfigurationDemo {

    @Value("${user.id}")
    private Long userId;

    @Bean(value = "user")
    public User createAnnotationUser(@Value("${user.id}") Long id, @Value("${user.localName}") String userName, @Value("${user.workCities}") City[] cities) {
        User user = new User();
        user.setName(userName);
        user.setId(id);
        user.setWorkCities(cities);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationExternalizedConfigurationDemo.class);

        applicationContext.refresh();
        User user = applicationContext.getBean("user", User.class);
        AnnotationExternalizedConfigurationDemo demo = applicationContext.getBean(AnnotationExternalizedConfigurationDemo.class);

        System.out.println(demo.userId);
        System.out.println(user);
        applicationContext.close();
    }

}
