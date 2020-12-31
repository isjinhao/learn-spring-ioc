package ab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sic.domain.User;

/**
 * @author 01395265
 * @date 2020/12/31
 */
@Configuration
public class MyConfiguration2 {

    @Bean
    public User user() {
        return new User(999L, "aha", null);
    }

}
