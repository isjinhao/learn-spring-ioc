package ab.configuration.importaware;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author ISJINHAO
 * @Date 2021/1/1 20:14
 */
@Import(MyConfigurationWithImportAware.class)
@Configuration
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConfigurationAnnotation {

    String testValue() default "hello world";

}
