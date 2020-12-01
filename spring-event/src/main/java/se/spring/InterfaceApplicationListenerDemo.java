package se.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/11/30 19:51
 */
public class InterfaceApplicationListenerDemo {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new GenericApplicationContext();

        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println(event);
            }
        });


        applicationContext.refresh();
        applicationContext.start();
        applicationContext.close();

    }

    static class MyApplicationContextEvent extends ApplicationEvent {

        /**
         * Create a new {@code ApplicationEvent}.
         *
         * @param source the object on which the event initially occurred or with
         *               which the event is associated (never {@code null})
         */
        public MyApplicationContextEvent(Object source) {
            super(source);
        }
    }

}
