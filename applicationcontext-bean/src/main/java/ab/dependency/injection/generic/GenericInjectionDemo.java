package ab.dependency.injection.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ISJINHAO
 * @Date 2020/12/14 15:31
 */
public class GenericInjectionDemo {

    @Autowired
    public List strs;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(GenericInjectionDemo.class);
        applicationContext.register(GenericInjectionBeanFactory.class);

        applicationContext.refresh();

        GenericInjectionDemo bean = applicationContext.getBean(GenericInjectionDemo.class);
        System.out.println(bean.strs);

        applicationContext.close();

    }

    static class GenericInjectionBeanFactory {

        @Bean
        private List<String> createStringStrs() {
            List<String> strings = new ArrayList<>();
            strings.add("1");
            strings.add("2");
            return strings;
        }

//        @Bean
//        private List<Object> createObjectStrs() {
//            List<Object> strings = new ArrayList<>();
//            strings.add("a");
//            strings.add("b");
//            return strings;
//        }

    }

}
