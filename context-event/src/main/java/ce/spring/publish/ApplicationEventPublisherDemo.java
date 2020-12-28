package ce.spring.publish;

import ce.spring.define._interface.CustomizedSpringEventDemo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;

import javax.annotation.PostConstruct;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 22:57
 */
public class ApplicationEventPublisherDemo implements ApplicationEventPublisherAware, ApplicationContextAware {

    @Autowired
    private ApplicationEventPublisher eventPublisherByAutowired;

    @Autowired
    private ApplicationContext applicationContext;

    private ApplicationEventPublisher getEventPublisherByAware;


    @PostConstruct
    public void init() {
        //# 3
        eventPublisherByAutowired.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from @Autowired ApplicationEventPublisher"));
        // #4
        applicationContext.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from @Autowired ApplicationContext"));
    }

    public static void main(String[] args) {

        // 创建注解驱动 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class
        context.register(ApplicationEventPublisherDemo.class);

        // 增加 Spring 事件监听器
        context.addApplicationListener(new CustomizedSpringEventDemo.MySpringEventListener());

        // 启动 Spring 应用上下文
        context.refresh();

        // 无法依赖查找，因为BeanFactory里面没有ApplicationEventPublisher的实现类
//        ApplicationEventPublisher eventPublisher = context.getBean(ApplicationEventPublisher.class);

        // ApplicationEventMulticaster是事件发布的底层接口
        ApplicationEventMulticaster eventMulticaster = context.getBean(ApplicationEventMulticaster.class);
        System.out.println(eventMulticaster);
        ApplicationEventPublisherDemo demo = context.getBean(ApplicationEventPublisherDemo.class);

        System.out.println(demo.applicationContext == demo.eventPublisherByAutowired);
        System.out.println(demo.applicationContext == demo.getEventPublisherByAware);

        // 关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) { // #1
        this.getEventPublisherByAware = applicationEventPublisher;
        applicationEventPublisher.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from ApplicationEventPublisherAware"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException { // #2
        eventPublisherByAutowired.publishEvent(new CustomizedSpringEventDemo.MySpringEvent1("The event from ApplicationContextAware"));
    }
}
