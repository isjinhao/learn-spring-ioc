package sio.repository;

import sic.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * @Author ISJINHAO
 * @Date 2020/12/1 16:41
 */
@Getter
@Setter
@ToString
public class UserRepository {

    private List<User> userList;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    private ObjectFactory<User> objectFactory;

    private Environment environment;

}
