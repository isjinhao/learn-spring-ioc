package ec.properties.visitbd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sic.domain.User;

/**
 * @Author ISJINHAO
 * @Date 2021/1/2 15:24
 */
@PropertySource("classpath:META-INF/visitbd.properties")
public class TestVisitBDDemo {

    @Value("${userName}")
    private String userName;

    public static void main(String[] args) {
        xmlTest();
        annotationTest();
    }

    private static void annotationTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 100).addPropertyValue("name", "${userName}");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        context.registerBeanDefinition("user", beanDefinition);

        context.register(TestVisitBDDemo.class);

        context.refresh();

        TestVisitBDDemo demo = context.getBean(TestVisitBDDemo.class);
        System.out.println(demo.userName);

        User user = context.getBean("user", User.class);
        System.out.println(user);

        context.close();
    }

    private static void xmlTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/xml-visitbd-context.xml");
        context.refresh();

        User test_visit_bd = context.getBean("user", User.class);
        System.out.println(test_visit_bd);
        context.close();
    }

}
