package ab.configuration.importaware;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2021/1/1 20:14
 */
@Configuration
public class MyConfigurationWithImportAware implements ImportAware {
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        Map<String, Object> map = importMetadata.getAnnotationAttributes(MyConfigurationAnnotation.class.getName());
        map.forEach((s, o) -> System.out.println(s + " " + o));
    }
}