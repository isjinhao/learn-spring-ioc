package ab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 01395265
 * @date 2020/12/31
 */
//@Configuration
public class MyConfiguration1 {

    @Bean
    public static MyConfiguration2 configuration2() {
        return new MyConfiguration2();
    }

}
