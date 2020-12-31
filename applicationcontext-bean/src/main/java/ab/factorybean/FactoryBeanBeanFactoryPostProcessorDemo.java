package ab.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/12/31
 */
public class FactoryBeanBeanFactoryPostProcessorDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FactoryBeanBeanFactoryPostProcessor.class);
        context.refresh();
        context.close();
    }

}
