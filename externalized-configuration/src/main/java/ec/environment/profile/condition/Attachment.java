package ec.environment.profile.condition;

import java.lang.annotation.*;

/**
 * @Author ISJINHAO
 * @Date 2020/12/27 20:45
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Attachment {
    String value();
}
