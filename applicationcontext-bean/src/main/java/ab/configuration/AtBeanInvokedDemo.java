package ab.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sic.domain.User;

/**
 * @author 01395265
 * @date 2020/12/31
 */
public class AtBeanInvokedDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfiguration.class);
        context.refresh();

        MyConfiguration configuration = context.getBean(MyConfiguration.class);

        User userRetrievedFromBean = context.getBean("createUser", User.class);
        User userRetrievedFromBean2 = context.getBean("defaultUser", User.class);
        System.out.println(userRetrievedFromBean2);

        System.out.println(userRetrievedFromBean.hashCode());
        User userRetrievedFromMethod = configuration.createUser();
        System.out.println(userRetrievedFromMethod.hashCode());

        System.out.println(userRetrievedFromBean == userRetrievedFromMethod);

    }

}
