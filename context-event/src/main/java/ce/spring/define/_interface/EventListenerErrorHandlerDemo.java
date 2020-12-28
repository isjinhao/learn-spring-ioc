package ce.spring.define._interface;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 15:55
 */
public class EventListenerErrorHandlerDemo {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/error-handler-event-context.xml");

        context.refresh();

        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                throw new RuntimeException("故意抛出异常");
            }
        });

        context.close();
    }

    static class EventMulticasterPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if(bean instanceof SimpleApplicationEventMulticaster) {
                SimpleApplicationEventMulticaster eventMulticaster = (SimpleApplicationEventMulticaster) bean;
                eventMulticaster.setErrorHandler(e -> {
                    System.err.println("Spring 事件监听发生异常，原因:  " + e.getMessage());
                });
            }
            return bean;
        }
    }

}
