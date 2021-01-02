package ab.configuration.importaware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2021/1/1 20:42
 */
@MyConfigurationAnnotation(testValue = "2021")
public class MyConfigurationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfigurationDemo.class);
        context.refresh();
        context.close();
    }

}
