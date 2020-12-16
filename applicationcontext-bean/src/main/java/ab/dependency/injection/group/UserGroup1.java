package ab.dependency.injection.group;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
/**
 * @Author ISJINHAO
 * @Date 2020/12/15 19:11
 */
public @interface UserGroup1 {
}
