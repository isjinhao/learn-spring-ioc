package bb.merge;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author 01395265
 * @date 2020/12/3
 */
public class BeanDefinitionMergeDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/bean-merge-context.xml";
        // 加载配置
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义的数量：" + beanDefinitionsCount);
        System.out.println(beanFactory.getBean("child-bean"));
        System.out.println("Bean 加载的数量：" + beanFactory.getSingletonCount());
        beanFactory.destroySingleton("child-bean");

    }
}
