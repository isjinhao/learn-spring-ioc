package bb.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author 01395265
 * @date 2020/12/3
 */
public class BeanFactoryLifeCycleDemo {

    static class TestMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
        @Override
        public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
            System.out.println("2、MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition：" + beanDefinition.getBeanClass());
        }
    }

    static class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            System.out.println("3、InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation：" + bean.getClass());
            return false;
        }
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            System.out.println("1、InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation：" + beanClass);
            return null;
        }
        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessProperties");
            return null;
        }
    }

    static class TestBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("7、BeanPostProcessor#postProcessBeforeInitialization：" + bean.getClass());
            return null;
        }
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("10、BeanPostProcessor#postProcessAfterInitialization：" + bean.getClass());
            return null;
        }
    }

    static class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
        @Override
        public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
            System.out.println("11、DestructionAwareBeanPostProcessor#postProcessBeforeDestruction：" + bean.getClass());
        }
    }

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "META-INF/bean-lifecycle-context.xml";
        // 加载配置
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量：" + beanDefinitionsCount);
        beanFactory.addBeanPostProcessor(new TestMergedBeanDefinitionPostProcessor());
        beanFactory.addBeanPostProcessor(new TestInstantiationAwareBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new TestBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
        // 依赖查找集合对象
        beanFactory.getBean("create-by-constructor");
        beanFactory.destroySingleton("create-by-constructor");
        System.out.println("----------------------------------");
        beanFactory.getBean("create-by-factory-bean");
        beanFactory.destroySingleton("create-by-factory-bean");
        System.out.println("----------------------------------");

    }

}
