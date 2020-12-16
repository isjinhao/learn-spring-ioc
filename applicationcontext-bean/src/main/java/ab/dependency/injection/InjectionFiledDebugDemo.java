package ab.dependency.injection;

import ab.holder.UserHolder;
import fsc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author ISJINHAO
 * @Date 2020/12/6 15:42
 */
@Import(InjectionMethodDebugDemo.class)
public class InjectionFiledDebugDemo {

    @Value(value = "")
    private String aaa;

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

    @Autowired
    private Optional<User> userOptional;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        applicationContext.register(InjectionFiledDebugDemo.class);

        applicationContext.refresh();

        InjectionFiledDebugDemo demo = applicationContext.getBean(InjectionFiledDebugDemo.class);

        System.out.println(demo.user);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolderList);
        System.out.println(demo.userHolderMap);
        demo.userHolderObjectProvider.stream().forEach(System.out::println);
        System.out.println(demo.userOptional);
        applicationContext.close();

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
