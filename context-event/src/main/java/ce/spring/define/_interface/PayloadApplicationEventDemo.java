package ce.spring.define._interface;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 15:55
 */
public class PayloadApplicationEventDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericXmlApplicationContext();
        context.registerBean(MyPayloadApplicationListener.class);
        context.refresh();

        context.publishEvent(new PayloadApplicationEvent(context, "hello world"));
        context.close();
    }

    static class MyPayloadApplicationListener implements ApplicationListener<PayloadApplicationEvent> {
        @Override
        public void onApplicationEvent(PayloadApplicationEvent event) {
            System.out.println(event.getSource() + " " + event.getPayload());
        }
    }

}
