package ec.yaml.xml;

import sic.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/17 21:41
 */
public class XmlYamlExternalizedConfigurationDemo {

    @Value("${user.id}")
    private Long userId;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/xml-yaml-ec-context.xml");

        applicationContext.refresh();
        User user = applicationContext.getBean("user", User.class);
        XmlYamlExternalizedConfigurationDemo demo = applicationContext.getBean("xmlYamlExternalizedConfigurationDemo", XmlYamlExternalizedConfigurationDemo.class);
        System.out.println(demo.userId);
        System.out.println(user);
        applicationContext.close();

    }
}
