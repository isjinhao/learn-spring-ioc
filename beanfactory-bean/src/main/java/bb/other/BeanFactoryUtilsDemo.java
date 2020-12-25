package bb.other;

import sic.domain.User;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Arrays;

/**
 * @Author ISJINHAO
 * @Date 2020/12/7 16:32
 */
public class BeanFactoryUtilsDemo {

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

        System.out.println(Arrays.deepToString(BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childFactory, User.class)));
        System.out.println(BeanFactoryUtils.beansOfTypeIncludingAncestors(childFactory, User.class));

    }

}
