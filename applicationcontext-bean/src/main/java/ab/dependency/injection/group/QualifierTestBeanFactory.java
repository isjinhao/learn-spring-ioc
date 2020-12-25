package ab.dependency.injection.group;

import sic.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @Author ISJINHAO
 * @Date 2020/12/14 15:07
 */
public class QualifierTestBeanFactory {

    @Bean
    @Qualifier
    public User user1() {
        return createUser(1L);
    }

    @Bean
    @Qualifier
    public User user2() {
        return createUser(2L);
    }

    @Bean
    public User use3() {
        return createUser(3L);
    }

    private static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

}
