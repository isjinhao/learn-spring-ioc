package ab.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/30 22:39
 */
public class LookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LookupTestBean.class);
        context.register(LookupDemo.class);
        context.register(HelloWorldService.class);
        context.refresh();

        LookupDemo bean = context.getBean(LookupDemo.class);
        System.out.println(bean.getClass());

        bean.print();

        LookupTestBean lookupTestBean123 = bean.lookupTestBean("123");
        LookupTestBean lookupTestBeanabc = bean.lookupTestBean("abc");
        System.out.println(lookupTestBean123);
        System.out.println(lookupTestBeanabc);

        lookupTestBean123.print();
        lookupTestBeanabc.print();

        context.close();

    }


    public void print() {
        System.out.println("---");
    }

    @Lookup
    protected LookupTestBean lookupTestBean(String msg) {
        System.out.println("aha");
        return null;
    }

}
