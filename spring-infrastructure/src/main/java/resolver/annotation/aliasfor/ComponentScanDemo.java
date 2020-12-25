package resolver.annotation.aliasfor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 21:08
 */
//@MyComponentScanImplicit(scanBasePackages = "resolver.annotation.aliasfor")
@MyComponentScanExplicit(packages = "resolver.annotation.aliasfor")
public class ComponentScanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(ComponentScanDemo.class);

        context.refresh();

        TestClass testClass = context.getBean(TestClass.class);

        System.out.println(testClass);

        context.close();
    }
}
