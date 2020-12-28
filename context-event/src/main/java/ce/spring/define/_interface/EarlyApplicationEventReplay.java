package ce.spring.define._interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 21:49ost
 */
public class EarlyApplicationEventReplay implements ApplicationEventPublisherAware, BeanPostProcessor {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        //# 3
        applicationEventPublisher.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from @Autowired ApplicationEventPublisher"));
        // #4
        applicationContext.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from @Autowired ApplicationContext"));
    }

    public static void main(String[] args) {

        // 创建注解驱动 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class
        context.register(EarlyApplicationEventReplay.class);

        // 增加 Spring 事件监听器
        context.addApplicationListener(new CustomizedSpringEventDemo.MySpringEventListener());

        // 启动 Spring 应用上下文
        context.refresh();

        // 关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from ApplicationEventPublisherAware"));
    }

}