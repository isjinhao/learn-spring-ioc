package ab.dependency.injection.construtor;

import ab.holder.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/7 10:33
 */
public class ApiDependencyConstructorInjectionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 生成 UserHolder 的 BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        // 注册 UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("constructorApiUserHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "META-INF/dependency-setter-injection.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        UserHolder userHolder = applicationContext.getBean("constructorApiUserHolder", UserHolder.class);
        System.out.println(userHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addConstructorArgReference("user");
        definitionBuilder.addPropertyValue("id", "constructor api dependency injection");
        return definitionBuilder.getBeanDefinition();
    }

}
