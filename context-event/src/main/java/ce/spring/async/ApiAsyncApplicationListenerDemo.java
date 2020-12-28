package ce.spring.async;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 19:45
 */
public class ApiAsyncApplicationListenerDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/define-bean-async-event-context.xml");

        context.refresh();

        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println(Thread.currentThread().getName() + " " + event.getSource());
            }
        });

        context.close();
    }

    static class EventMulticasterPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if(bean instanceof SimpleApplicationEventMulticaster) {
                SimpleApplicationEventMulticaster eventMulticaster = (SimpleApplicationEventMulticaster) bean;
                ExecutorService taskExecutor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-thread-pool-"));
                eventMulticaster.setTaskExecutor(taskExecutor);
                eventMulticaster.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                    @Override
                    public void onApplicationEvent(ContextClosedEvent event) {
                        if (!taskExecutor.isShutdown()) {
                            taskExecutor.shutdown();
                        }
                    }
                });
            }
            return bean;
        }
    }

}
