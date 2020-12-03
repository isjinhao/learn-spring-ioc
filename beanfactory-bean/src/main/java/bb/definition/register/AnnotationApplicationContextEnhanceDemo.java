package bb.definition.register;

import fsc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2020/12/1 18:59
 */
//@Import(AnnotationApplicationContextEnhanceDemo.Config.class)
public class AnnotationApplicationContextEnhanceDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类作为配置类
        applicationContext.register(AnnotationApplicationContextEnhanceDemo.Config.class);

//        applicationContext.scan("sb.bean.register");

        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        System.out.println(beansOfType);
        // 关闭应用上下文
        applicationContext.close();
    }


    public static class Config {
        @Bean(name = {"user", "isjinhao"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小马哥");
            return user;
        }
    }

}