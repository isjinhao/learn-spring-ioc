package al;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author ISJINHAO
 * @Date 2020/12/28 19:12
 */
public class TestLifeCycleBeanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestLifeCycleBeanDemo.class);
        context.registerShutdownHook();
        context.refresh();
        context.start();;
        context.close();
    }

    @Bean
    public TestLifeCycleBean testLifeCycleBean() {
        return new TestLifeCycleBean();
    }

}
