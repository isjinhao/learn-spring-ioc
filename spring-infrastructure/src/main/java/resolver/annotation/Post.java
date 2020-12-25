package resolver.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author ISJINHAO
 * @Date 2020/12/23 17:40
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Request
@interface Post {

    @AliasFor(annotation = Request.class)
    String name() default "";

    @AliasFor(annotation = Request.class)
    String[] value() default {};

    @AliasFor(annotation = Request.class)
    String[] path() default {};
}