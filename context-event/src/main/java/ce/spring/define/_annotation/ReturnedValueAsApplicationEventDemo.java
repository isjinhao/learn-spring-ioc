package ce.spring.define._annotation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author ISJINHAO
 * @Date 2020/11/30 19:51
 */
@EnableAsync
public class ReturnedValueAsApplicationEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ReturnedValueAsApplicationEventDemo.class);
        applicationContext.refresh();
        applicationContext.close();
    }

    @EventListener
    public MyApplicationEvent onApplicationRefresh(ContextRefreshedEvent event) {
        System.out.println(event.getSource());
        return new MyApplicationEvent("hello world");
    }

    @EventListener
    public void onMyApplicationEvent(MyApplicationEvent event) {
        System.out.println("传播下来的事件:  " + event.getSource());
    }

    static class MyApplicationEvent extends ApplicationEvent {
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
