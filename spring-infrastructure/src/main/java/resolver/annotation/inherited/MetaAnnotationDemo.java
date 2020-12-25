package resolver.annotation.inherited;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 9:22
 * @Description
 */
public class MetaAnnotationDemo {

    public static void main(String[] args) throws Exception {
        Class<SubDomain> subDomainClass = SubDomain.class;

        System.out.println("JDK获取子类上的注解 ------------------------------");
        Annotation[] subClassAnnotations = subDomainClass.getAnnotations();
        for (Annotation annotation : subClassAnnotations) {
            System.out.println(annotation);
        }


        System.out.println("\nSpring AnnotationUtils获取子类上的注解 ------------------------------");
        TestedMetaAnnotation springFindClassAnnotation = AnnotationUtils.findAnnotation(subDomainClass, TestedMetaAnnotation.class);
        System.out.println(springFindClassAnnotation);


        System.out.println("\nJDK获取子类方法上的注解------------------------------");
        Method test = subDomainClass.getMethod("test");
        Annotation[] subClassMethodAnnotations = test.getAnnotations();
        for (Annotation annotation : subClassMethodAnnotations) {
            System.out.println(annotation);
        }


        System.out.println("\nSpring AnnotationUtils获取子类方法上的注解 ------------------------------");
        TestedMetaAnnotation springFindMethodAnnotation = AnnotationUtils.findAnnotation(test, TestedMetaAnnotation.class);
        System.out.println(springFindMethodAnnotation);


        System.out.println("\nJDK获取获取子类属性上的注解 ------------------------------");
        Field testFiled = subDomainClass.getField("test");
        Annotation[] subClassFiledAnnotations = testFiled.getAnnotations();
        for (Annotation annotation : subClassFiledAnnotations) {
            System.out.println(annotation);
        }


        System.out.println("\nSpring AnnotationUtils获取子类属性上的注解 ------------------------------");
        System.out.println("Spring没有提供获取子类属性注解的方式 ------------------------------");


    }

    @TestedMetaAnnotation
    static class Domain {
        @TestedMetaAnnotation
        public String test;

        @TestedMetaAnnotation
        public void test() {}
    }

    static class SubDomain extends Domain {
        public String test;

        @Override
        public void test() {}
    }

}