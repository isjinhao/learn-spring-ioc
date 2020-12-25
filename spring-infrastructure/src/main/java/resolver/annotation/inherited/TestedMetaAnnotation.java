package resolver.annotation.inherited;

import java.lang.annotation.*;

/**
 * @author 01395265
 * @date 2020/12/22
 */
//@Inherited
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestedMetaAnnotation {

}
