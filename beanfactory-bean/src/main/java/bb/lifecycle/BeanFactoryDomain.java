package bb.lifecycle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 01395265
 * @date 2020/12/3
 */
@Getter
@Setter
@ToString
public class BeanFactoryDomain implements DisposableBean, InitializingBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {

    private Integer age;
    private String name;

    public BeanFactoryDomain(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("12、DisposableBean#destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("8、InitializingBean#afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("5、BeanClassLoaderAware#setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("6、BeanFactoryAware#setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("4、BeanNameAware#setBeanName");
    }

    public void myInitMethod() {
        System.out.println("9、myInitMethod");
    }

    public void myDestroyMethod () {
        System.out.println("13、myDestroyMethod");
    }

}
