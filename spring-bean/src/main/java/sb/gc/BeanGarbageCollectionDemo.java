package sb.gc;

import fsc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sb.initialization.BeanInitializationDemo;

/**
 * @author 01395265
 * @date 2020/9/28
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);

        System.out.println("Spring上下文准备关闭");
        applicationContext.close();
        System.out.println("Spring上下文已经关闭");

        Thread.sleep(10000L);
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        Thread.sleep(10000L);

    }
}