package bb.merge;

import fsc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/12/3
 */
public class BeanDefinitionMergeDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "META-INF/bean-merge-context.xml";
        // 加载配置

        ObjectProvider<User> beanProvider = beanFactory.getBeanProvider(User.class);


        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义的数量：" + beanDefinitionsCount);
        System.out.println(beanFactory.getBean("child-bean"));
        System.out.println("Bean 加载的数量：" + beanFactory.getSingletonCount());
        beanFactory.destroySingleton("child-bean");

    }
}
