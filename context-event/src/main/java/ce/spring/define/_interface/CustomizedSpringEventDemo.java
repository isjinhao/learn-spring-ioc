package ce.spring.define._interface;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 19:52
 */
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new MySpringEventListener());

        context.addApplicationListener(event -> System.out.println("监听ApplicationContext的全部事件 : " + event.getSource()));

        context.refresh();

        context.publishEvent(new MySpringEvent1("MySpringEvent1 Hello,World"));
        context.publishEvent(new MySpringEvent2("MySpringEvent2 Hello,World"));

        context.close();
    }

    static public class MySpringEvent1 extends ApplicationEvent {
        public MySpringEvent1(String message) {
            super(message);
        }
        @Override
        public String getSource() {
            return (String) super.getSource();
        }
    }

    static public class MySpringEvent2 extends ApplicationEvent {
        public MySpringEvent2(String message) {
            super(message);
        }
        @Override
        public String getSource() {
            return (String) super.getSource();
        }
    }

    static public class MySpringEventListener implements ApplicationListener<MySpringEvent1> {
        @Override
        public void onApplicationEvent(MySpringEvent1 event) {
            System.out.printf("自定义监听器监听到 : %s\n", event.getSource());
        }
    }

}
