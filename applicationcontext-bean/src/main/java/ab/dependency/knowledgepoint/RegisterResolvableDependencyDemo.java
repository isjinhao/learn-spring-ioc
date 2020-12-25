package ab.dependency.knowledgepoint;

import ab.holder.ACDomain;
import sic.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 13:14
 */
public class RegisterResolvableDependencyDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/bean-acdomain-context.xml");

        applicationContext.refresh();

        applicationContext.getBeanFactory().ignoreDependencyType(User.class);

        ACDomain acDomain = applicationContext.getBean("acDomain", ACDomain.class);

        // 没有结果
        Map<String, BeanFactory> beansOfType = applicationContext.getBeansOfType(BeanFactory.class);
        System.out.println(beansOfType);

        System.out.println(acDomain.getApplicationContext());
        System.out.println(acDomain.getBeanFactory());

        applicationContext.close();

    }

}
