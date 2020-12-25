package ec.properties.xml;

import sic.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/16 10:44
 */
public class XmlBeanExternalizedConfigurationDemo {

    @Value("${user.id}")
    private Long userId;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/xml-bean-ec-context.xml");

        applicationContext.refresh();
        User user = applicationContext.getBean("user", User.class);
        XmlBeanExternalizedConfigurationDemo demo = applicationContext.getBean("xmlBeanExternalizedConfigurationDemo", XmlBeanExternalizedConfigurationDemo.class);
        System.out.println(demo.userId);
        System.out.println(user);
        applicationContext.close();

    }

}
