package resolver.annotation.aliasfor;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 21:07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponentScanImplicit
public @interface MyComponentScanExplicit {

    // 属性继承
    String[] scanBasePackages() default {};

    @AliasFor("scanBasePackages")   // 显性别名
    String[] packages() default {};

}
