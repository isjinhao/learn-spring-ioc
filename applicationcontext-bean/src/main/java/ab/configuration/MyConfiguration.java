package ab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sic.domain.User;

/**
 * @author 01395265
 * @date 2020/12/31
 */
@Configuration(proxyBeanMethods = true)
public class MyConfiguration implements MyConfigurationInterface {

    @Bean
    public User createUser() {
        return new User(999L, "aha", null);
    }

}
