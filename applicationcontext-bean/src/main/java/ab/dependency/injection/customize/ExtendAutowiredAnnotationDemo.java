package ab.dependency.injection.customize;

import fsc.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

/**
 * @Author ISJINHAO
 * @Date 2020/12/14 15:17
 */
public class ExtendAutowiredAnnotationDemo {

    @MyAutowired
    private Optional<User> userOptional;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(ExtendAutowiredAnnotationDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "META-INF/dependency-setter-injection.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        ExtendAutowiredAnnotationDemo demo = applicationContext.getBean(ExtendAutowiredAnnotationDemo.class);

        System.out.println("demo.userOptional = " + demo.userOptional);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}