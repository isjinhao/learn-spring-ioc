package ce.spring.async;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ISJINHAO
 * @Date 2020/11/30 19:51
 */
@EnableAsync
public class InjectBeanAsyncApplicationListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MyApplicationListener.class);
        applicationContext.register(InjectBeanAsyncApplicationListenerDemo.class);

        applicationContext.refresh();
        applicationContext.close();
    }

    static class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
        @Async
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println(Thread.currentThread() + "   " + event.getSource());
        }
    }

    @Bean
    public Executor taskExecutor() {
        ExecutorService taskExecutor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-thread-pool-"));
        return taskExecutor;
    }

}
