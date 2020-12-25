package bb.other.hierarchial;

import sic.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author ISJINHAO
 * @Date 2020/12/4 16:44
 */
public class HierarchicalDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory parentFactory = new DefaultListableBeanFactory();
        DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory();
        childFactory.setParentBeanFactory(parentFactory);

        // 在父工厂中定义一个parentBean
        BeanDefinitionBuilder beanDefinitionBuilder1 = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder1.addPropertyValue("id", 1);
        beanDefinitionBuilder1.addPropertyValue("name", "isjinhao");
        AbstractBeanDefinition beanDefinition1 = beanDefinitionBuilder1.getBeanDefinition();
        parentFactory.registerBeanDefinition("parentBean", beanDefinition1);
        // 在子工厂中定义一个childBean
        BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder2.addPropertyValue("id", 2);
        beanDefinitionBuilder2.addPropertyValue("name", "zhanjinhao");
        AbstractBeanDefinition beanDefinition2 = beanDefinitionBuilder2.getBeanDefinition();
        childFactory.registerBeanDefinition("childBean", beanDefinition2);

        // 子工厂获取父亲的Bean，可以获取到
        System.out.println(childFactory.getBean("parentBean"));
        // 父工厂获取孩子的Bean，抛异常
        System.out.println(parentFactory.getBean("childBean"));
    }

}
