package resolver.annotation.inherited;

import org.springframework.core.annotation.*;
import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author ISJINHAO
 * @Date 2020/12/22 20:24
 */
public class MyAnnotationUtils extends AnnotationUtils {

    public static <A extends Annotation> A findAnnotation(Field filed, @Nullable Class<A> annotationType) {
        if (annotationType == null) {
            return null;
        }

        // Exhaustive retrieval of merged annotations...
        return MergedAnnotations.from(filed, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY, RepeatableContainers.none())
                .get(annotationType).withNonMergedAttributes()
                .synthesize(MergedAnnotation::isPresent).orElse(null);

    }

}
