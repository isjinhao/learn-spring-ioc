package ab.dependency.injection.group;

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
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    @Qualifier("user1")
    private User namedUser;

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(QualifierTestBeanFactory.class);
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        System.out.println(applicationContext.getBeansOfType(User.class));
        System.out.println("demo.namedUser = " + demo.namedUser);
        System.out.println("demo.allUsers = " + demo.allUsers);
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
