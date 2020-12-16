package ab.dependency.injection.group;

import fsc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 * @Author ISJINHAO
 * @Date 2020/12/7 10:55
 */
public class CustomizeQualifierAnnotationDependencyInjectionDemo {

//    @Autowired
//    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup1
    private Collection<User> group1Users;

    @Autowired
    @UserGroup2
    private Collection<User> group2Users;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(GroupTestBeanFactory.class);
        applicationContext.register(CustomizeQualifierAnnotationDependencyInjectionDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        CustomizeQualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(CustomizeQualifierAnnotationDependencyInjectionDemo.class);

        System.out.println("demo.allUsers = ");
//        demo.allUsers.stream().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("demo.qualifiedUsers = ");
//        demo.qualifiedUsers.stream().forEach(System.out::println);
        System.out.println("-----------------------------");

        System.out.println("demo.group1Users = ");
        demo.group1Users.stream().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("demo.group2Users = ");
        demo.group2Users.stream().forEach(System.out::println);
        System.out.println("-----------------------------");

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
