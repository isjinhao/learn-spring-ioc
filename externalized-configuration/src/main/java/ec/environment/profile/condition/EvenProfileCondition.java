package ec.environment.profile.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;

/**
 * @Author ISJINHAO
 * @Date 2020/12/26 20:57
 */
public class EvenProfileCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MergedAnnotations annotations = metadata.getAnnotations();

        for (MergedAnnotation<Annotation> annotation : annotations) {
            System.out.println(annotation);
            if(annotation.getType().equals(Attachment.class)) {
                String value = annotation.getString("value");
                if(value.equals("even")) {
                    return true;
                }
            }
        }

        // 条件上下文
        return false;
    }

}
