package ab.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author 01395265
 * @date 2020/12/31
 */
public class FactoryBeanBeanFactoryPostProcessor implements FactoryBean<MyBeanFactoryPostProcessor> {

    @Override
    public MyBeanFactoryPostProcessor getObject() throws Exception {
        return new MyBeanFactoryPostProcessor();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBeanFactoryPostProcessor.class;
    }
}

class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor is invoked !");
    }
}