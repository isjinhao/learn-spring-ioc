package ec.environment.profile.condition;

import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 20:46
 */
public class ConditionalDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConditionalDemo.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setDefaultProfiles("odd");
        context.refresh();

        Integer number = context.getBean("number", Integer.class);
        System.out.println(number);
        context.close();
    }

    @Conditional(EvenProfileCondition.class)
    @Bean(name = "number")
    @Attachment(value = "odd")
    public Integer odd() {
        return 1;
    }

    @Conditional(EvenProfileCondition.class)
    @Bean(name = "number")
    @Attachment(value = "even")
    public Integer even() {
        return 2;
    }

}
