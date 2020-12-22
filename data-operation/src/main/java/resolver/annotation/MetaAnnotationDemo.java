package resolver.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 9:22
 * @Description
 */
public class MetaAnnotationDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        Class<SubDomain> subDomainClass = SubDomain.class;

        System.out.println("子类上的注解 ---------------------------------");
        Annotation[] subAnnotations = subDomainClass.getAnnotations();
        for (Annotation annotation : subAnnotations) {
            System.out.println(annotation);
        }

        System.out.println("子类方法上的注解---------------------------------");
        Method test = subDomainClass.getMethod("test");
        Annotation[] annotations = test.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("Spring AnnotationUtils获取子类方法上的注解 ---------------------------------");
        TestedMetaAnnotation springFoundAnnotation = AnnotationUtils.findAnnotation(test, TestedMetaAnnotation.class);
        System.out.println(springFoundAnnotation);

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