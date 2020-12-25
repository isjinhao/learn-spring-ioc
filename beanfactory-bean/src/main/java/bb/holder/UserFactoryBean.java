package bb.holder;

import sic.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 01395265
 * @date 2020/9/28
 */
public class UserFactoryBean implements FactoryBean<User>, InitializingBean, DisposableBean {

    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("isjinhao");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口 : User 初始化中 ... ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口 : User 销毁中...");
    }
}
