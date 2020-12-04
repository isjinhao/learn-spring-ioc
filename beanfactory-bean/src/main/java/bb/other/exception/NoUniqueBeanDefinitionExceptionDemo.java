package bb.other.exception;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author ISJINHAO
 * @Date 2020/12/3 22:06
 */
public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {

        // 这里偷个懒，使用了注解，但是getBean()方法底层还是调用了DefaultListableBeanFactory的getBean()

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 NoUniqueBeanDefinitionExceptionDemo 作为配置类（Configuration Class）
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        // 启动应用上下文
        applicationContext.refresh();

        try {
            // 由于 Spring 应用上下文存在两个 String 类型的 Bean，通过单一类型查找会抛出异常
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.err.printf(" Spring 应用上下文存在%d个 %s 类型的 Bean，具体原因：%s%n",
                    e.getNumberOfBeansFound(),
                    String.class.getName(),
                    e.getMessage());
        }
        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String bean1() {
        return "1";
    }

    @Bean
    public String bean2() {
        return "2";
    }

    @Bean
    public String bean3() {
        return "3";
    }
}
