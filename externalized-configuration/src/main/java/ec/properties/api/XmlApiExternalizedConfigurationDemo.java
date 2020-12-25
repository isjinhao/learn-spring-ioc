package ec.properties.api;

import sic.domain.City;
import sic.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @Author ISJINHAO
 * @Date 2020/12/18 16:37
 */
public class XmlApiExternalizedConfigurationDemo {

    @Value("${user.id}")
    private Long userId;

    @Bean(value = "user")
    public User createAnnotationUser(@Value("${user.id}") Long id, @Value("${user.localName}") String userName, @Value("${user.workCities}") City[] cities) {
        User user = new User();
        user.setName(userName);
        user.setId(id);
        user.setWorkCities(cities);
        return user;
    }

    public static void main(String[] args) {

        GenericApplicationContext applicationContext = new GenericApplicationContext();

        XmlBeanDefinitionReader xmlBeanDefinitionReader =new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("META-INF/xml-api-ec-context.xml");

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(PropertySourcesPlaceholderConfigurer.class);
        beanDefinitionBuilder.addPropertyValue("location", "META-INF/user.properties");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        String beanName = DefaultBeanNameGenerator.INSTANCE.generateBeanName(beanDefinition, applicationContext);
        applicationContext.registerBeanDefinition(beanName, beanDefinition);

        applicationContext.refresh();
        User user = applicationContext.getBean("user", User.class);
        XmlApiExternalizedConfigurationDemo demo =
                applicationContext.getBean("xmlApiExternalizedConfigurationDemo", XmlApiExternalizedConfigurationDemo.class);
        System.out.println(demo.userId);
        System.out.println(user);
        applicationContext.close();

    }


}
