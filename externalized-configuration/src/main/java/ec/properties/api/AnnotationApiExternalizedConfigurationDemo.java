package ec.properties.api;

import fsc.domain.City;
import fsc.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author ISJINHAO
 * @Date 2020/12/18 16:37
 */
public class AnnotationApiExternalizedConfigurationDemo {

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

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApiExternalizedConfigurationDemo.class);

        InputStream resourceAsStream = AnnotationApiExternalizedConfigurationDemo
                .class.getResourceAsStream("/META-INF/user.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        PropertiesPropertySource propertiesPropertySource =
                new PropertiesPropertySource("customized-property-source", properties);
        applicationContext.getEnvironment().getPropertySources().addFirst(propertiesPropertySource);

        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        AnnotationApiExternalizedConfigurationDemo demo = applicationContext.getBean(AnnotationApiExternalizedConfigurationDemo.class);
        System.out.println(demo.userId);
        System.out.println(user);
        applicationContext.close();

    }

}
