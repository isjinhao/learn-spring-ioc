package se.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author ISJINHAO
 * @Date 2020/11/30 19:51
 */
@EnableAsync
public class AnnotationApplicationListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationListenerDemo.class);
        applicationContext.refresh();
        applicationContext.start();
        applicationContext.close();
    }

    @EventListener
    @Order(2)
    public void onApplicationEvent1(ContextRefreshedEvent event) {
        System.out.println("onApplicationEvent1");
    }


    @EventListener
    @Order(1)
    public void onApplicationEvent2(ContextRefreshedEvent event) {
        System.out.println("onApplicationEvent2");
    }

    @EventListener
    @Async
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println(Thread.currentThread() + " " + event);
    }

}
