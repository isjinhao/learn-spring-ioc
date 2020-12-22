package resolver.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 9:22
 * @Description
 */
public class MetaAnnotationDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        Class<SubDomain> subDomainClass = SubDomain.class;

        Annotation[] declaredAnnotations = subDomainClass.getAnnotations();

        for (Annotation annotation : declaredAnnotations) {
            System.out.println(annotation);
        }

        System.out.println("---------------------------------");
        for (Annotation declaredAnnotation : Domain.class.getAnnotations()) {
            System.out.println(declaredAnnotation);
        }

        System.out.println("---------------------------------");

        Method test = subDomainClass.getMethod("test");

        Annotation[] annotations = test.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @TestedMetaAnnotation
    static class Domain {

        @TestedMetaAnnotation
        public void test() {}

    }

    static class SubDomain extends Domain {
        @Override
        public void test() {}
    }

}
