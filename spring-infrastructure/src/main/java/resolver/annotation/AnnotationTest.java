package resolver.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @Author ISJINHAO
 * @Date 2020/12/23 17:20
 */
public class AnnotationTest {
    public static void main(String[] args) {
        print("Parent getAnnotation @Request:         " + AnnotationUtils.getAnnotation(Parent.class, Request.class));
        print("Child  getAnnotation @Request:         " + AnnotationUtils.getAnnotation(Child.class, Request.class));
        print();

        print("Parent findAnnotation @Request:        " + AnnotationUtils.findAnnotation(Parent.class, Request.class));
        print("Child  findAnnotation @Request:        " + AnnotationUtils.findAnnotation(Child.class, Request.class));
        print();

        print("Parent isAnnotated @Request:           " + AnnotatedElementUtils.isAnnotated(Parent.class, Request.class));
        print("Parent getMergedAnnotation @Request:   " + AnnotatedElementUtils.getMergedAnnotation(Parent.class, Request.class));
        print("Child  isAnnotated @Request:           " + AnnotatedElementUtils.isAnnotated(Child.class, Request.class));
        print("Child  getMergedAnnotation @Request:   " + AnnotatedElementUtils.getMergedAnnotation(Child.class, Request.class));
        print();

        print("Parent hasAnnotation @Request:         " + AnnotatedElementUtils.hasAnnotation(Parent.class, Request.class));
        print("Parent findMergedAnnotation @Request:  " + AnnotatedElementUtils.findMergedAnnotation(Parent.class, Request.class));
        print("Child  hasAnnotation @Request:         " + AnnotatedElementUtils.hasAnnotation(Child.class, Request.class));
        print("Child  findMergedAnnotation @Request:  " + AnnotatedElementUtils.findMergedAnnotation(Child.class, Request.class));
    }


    static void print(String ...str) {
        if(str != null && str.length != 0) {
            System.out.println(str[0]);
        } else {
            System.out.println();
        }
    }
}

@Post(value = "parent", name = "parent controller")
class Parent {
}

@Request(path = "child", name = "child controller")
class Child extends Parent {
}