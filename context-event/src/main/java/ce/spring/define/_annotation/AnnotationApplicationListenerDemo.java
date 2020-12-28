package ce.spring.define._annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
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
        applicationContext.stop();
        applicationContext.close();
    }

    @EventListener
    public void onApplicationRefresh(ContextRefreshedEvent event) {
        System.out.println(event);
    }

    @EventListener
    public void onApplicationStart(ContextStartedEvent event) {
        System.out.println(event);
    }

    @EventListener
    public void onApplicationStop(ContextStoppedEvent event) {
        System.out.println(event);
    }

    @EventListener
    public void onApplicationClose(ContextClosedEvent event) {
        System.out.println(event);
    }

}
