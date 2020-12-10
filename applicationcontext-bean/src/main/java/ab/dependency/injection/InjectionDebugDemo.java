package ab.dependency.injection;

import ab.holder.InjectionDebugDomain;
import ab.holder.UserHolder;
import fsc.domain.City;
import fsc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2020/12/6 15:42
 */
public class InjectionDebugDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("userHolder1")
    private UserHolder userHolder;

    @Autowired
    private List<UserHolder> userHolderList;

    @Autowired
    private Map<String, UserHolder> userHolderMap;

    @Autowired
    private ObjectProvider<UserHolder> userHolderObjectProvider;

    private User userInjectedByMethod;

    @Lazy
    @Autowired
    private void init(User user, User user2) {
        this.userInjectedByMethod = user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        applicationContext.register(InjectionDebugDemo.class);

        applicationContext.refresh();

        InjectionDebugDemo demo = applicationContext.getBean(InjectionDebugDemo.class);

        System.out.println(demo.user);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolderList);
        System.out.println(demo.userHolderMap);
        demo.userHolderObjectProvider.stream().forEach(System.out::println);
        applicationContext.close();

    }

    @Bean
    public User user() {
        return new User(888L, "jinhao", City.SHENZHEN);
    }

    @Bean
    public UserHolder userHolder1(User user) {
        UserHolder userHolder = new UserHolder(user);
        userHolder.setId("userHolder1");
        return userHolder;
    }

    @Bean
    public UserHolder userHolder2(User user) {
        UserHolder userHolder = new UserHolder(user);
        userHolder.setId("userHolder2");
        return userHolder;
    }


}
