package ab.dependency.injection.group;

import fsc.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @Author ISJINHAO
 * @Date 2020/12/14 15:12
 */
public class GroupTestBeanFactory {

    @Bean
    public User user1() {
        return createUser(1L);
    }

    @Bean
    @Qualifier
    public User user2() {
        return createUser(2L);
    }

    @Bean
    @UserGroup1
    public static User user3() {
        return createUser(3L);
    }

    @Bean
    @UserGroup1
    public static User user4() {
        return createUser(4L);
    }

    @Bean
    @UserGroup2
    public static User user5() {
        return createUser(5L);
    }

    @Bean
    @UserGroup2
    public static User user6() {
        return createUser(6L);
    }

    private static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }


}
