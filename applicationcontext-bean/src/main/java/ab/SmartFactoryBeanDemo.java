package ab;

import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 22:23
 */
public class SmartFactoryBeanDemo implements SmartFactoryBean<String> {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"META-INF/bean-smartfactorybean-context.xml"}, false, null);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("&smartfactorybean"));
        applicationContext.close();

    }

    @Override
    public String getObject() throws Exception {
        System.out.println("SmartFactoryBean 内部真实的Bean被初始化");
        return "SmartFactoryBean aha";
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isEagerInit() {
        return true;
    }
}
