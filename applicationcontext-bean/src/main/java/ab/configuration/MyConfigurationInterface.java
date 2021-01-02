package ab.configuration;

import org.springframework.context.annotation.Bean;
import sic.domain.User;

/**
 * @Author ISJINHAO
 * @Date 2021/1/1 22:05
 */
public interface MyConfigurationInterface {

    @Bean
    default User defaultUser() {
        return new User(1L, "hengha", null);
    }

}
