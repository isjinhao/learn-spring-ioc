package bb.other.exception;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author ISJINHAO
 * @Date 2020/12/3 22:06
 */
public class BeanCreationExceptionDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册 BeanDefinition Bean Class 是一个 POJO 普通类，不过初始化方法回调时抛出异常
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        beanFactory.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());
        System.out.println(beanFactory.getBean(POJO.class));
    }

    static class POJO implements InitializingBean {
        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet() : exception ...");
        }
    }
}
