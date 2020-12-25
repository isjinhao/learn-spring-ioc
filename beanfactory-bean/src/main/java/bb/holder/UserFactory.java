package bb.holder;

import sic.domain.User;

/**
 * @author 01395265
 * @date 2020/9/28
 */
public class UserFactory implements UserFactoryInterface {

    @Override
    public User createUserByInstanceMethod() {
        User user = new User();
        user.setId(1L);
        user.setName("isjinhao");
        return user;
    }

    public static User createUserByStaticMethod() {
        User user = new User();
        user.setId(1L);
        user.setName("isjinhao");
        return user;
    }

}
