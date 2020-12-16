package ab.dependency.injection.setter;

import ab.holder.UserHolder;
import fsc.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author ISJINHAO
 * @Date 2020/12/6 19:12
 */
public class AnnotationDependencySetterInjectionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationDependencySetterInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "META-INF/dependency-setter-injection.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        UserHolder userHolder = applicationContext.getBean("annotationUserHolder", UserHolder.class);
        System.out.println(userHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }


    @Bean
    public UserHolder annotationUserHolder(User user) {
        UserHolder userHolder = new UserHolder(user);
        userHolder.setId("annotation dependency setter injection");
        return userHolder;
    }
}
