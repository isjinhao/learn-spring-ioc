package ab.dependency.injection.construtor;

import ab.holder.UserHolder;
import sic.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/7 10:30
 */
public class AnnotationDependencyConstructorInjectionDemo {

    private UserHolder userHolder;

    @Autowired
    public AnnotationDependencyConstructorInjectionDemo(User user) {
        UserHolder userHolder = new UserHolder(user);
        userHolder.setId("annotation dependency constructor injection");
        this.userHolder = userHolder;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "META-INF/dependency-setter-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        AnnotationDependencyConstructorInjectionDemo demo = applicationContext.getBean(AnnotationDependencyConstructorInjectionDemo.class);
        System.out.println(demo.userHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
