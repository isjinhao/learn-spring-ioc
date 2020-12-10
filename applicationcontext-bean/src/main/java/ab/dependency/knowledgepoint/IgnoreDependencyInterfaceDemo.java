package ab.dependency.knowledgepoint;

import ab.holder.IgnoreInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 13:13
 */
public class IgnoreDependencyInterfaceDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/bean-ignore-context.xml");

        applicationContext.refresh();

        applicationContext.getBeanFactory().ignoreDependencyInterface(IgnoreInterface.class);

        System.out.println(applicationContext.getBean("ignore-test-bean"));

        applicationContext.close();
    }

}
