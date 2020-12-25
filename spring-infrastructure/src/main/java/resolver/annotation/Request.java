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
@interface Request {

    String name() default "";

    @AliasFor("path")
    String[] value() default {};


    @AliasFor("value")
    String[] path() default {};
}

