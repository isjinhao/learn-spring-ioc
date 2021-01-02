package ab;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.LiveBeansView;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 22:23
 */
public class SmartInitializingFactoryBeanDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"META-INF/bean-smartinitializing-context.xml"}, false, null);
        applicationContext.refresh();
        applicationContext.close();

    }

    static class MyBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println(beanName + " 实例化完成！");
            return null;
        }
    }

}
