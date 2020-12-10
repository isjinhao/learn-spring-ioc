package ab.dependency.injection.customize;

import fsc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @Author ISJINHAO
 * @Date 2020/12/7 10:55
 */
public class CustomizeQualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user1")
    private User namedUser;

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup1
    private Collection<User> group1Users;

    @Autowired
    @UserGroup2
    private Collection<User> group2Users;

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

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(CustomizeQualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "META-INF/dependency-setter-injection.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();


        CustomizeQualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(CustomizeQualifierAnnotationDependencyInjectionDemo.class);

        System.out.println(applicationContext.getBeansOfType(User.class));
        System.out.println("demo.user = " + demo.user);
        System.out.println("demo.namedUser = " + demo.namedUser);
        System.out.println("demo.allUsers = " + demo.allUsers);
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);
        System.out.println("demo.groupedUsers = " + demo.group1Users);
        System.out.println("demo.groupedUsers = " + demo.group2Users);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
