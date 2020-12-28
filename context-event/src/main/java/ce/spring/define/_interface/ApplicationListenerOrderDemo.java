package ce.spring.define._interface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
import org.springframework.core.annotation.Order;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 13:58
 */
public class ApplicationListenerOrderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationListenerOrderDemo.class);
        applicationContext.refresh();
        applicationContext.close();
    }

    @Order(4)
    @EventListener
    public void onApplicationRefresh4(ContextRefreshedEvent event) {
        System.out.println("onApplicationRefresh4  " + event.getSource());
    }
    @Order(2)
    @EventListener
    public void onApplicationRefresh2(ContextRefreshedEvent event) {
        System.out.println("onApplicationRefresh2  " + event.getSource());
    }
    @Order(1)
    @EventListener
    public void onApplicationRefresh1(ContextRefreshedEvent event) {
        System.out.println("onApplicationRefresh1  " + event.getSource());
    }
    @Order(3)
    @EventListener
    public void onApplicationRefresh3(ContextRefreshedEvent event) {
        System.out.println("onApplicationRefresh3  " + event.getSource());
    }

}
