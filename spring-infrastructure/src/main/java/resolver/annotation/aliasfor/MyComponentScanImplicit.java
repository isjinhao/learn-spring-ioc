package resolver.annotation.aliasfor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 21:07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan
public @interface MyComponentScanImplicit {

    @AliasFor(annotation = ComponentScan.class, attribute = "basePackages") // 隐性别名
    String[] scanBasePackages() default {};

}
