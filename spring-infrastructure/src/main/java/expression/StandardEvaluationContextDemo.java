package expression;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author 01395265
 * @date 2020/12/31
 */
public class StandardEvaluationContextDemo {

    public static void main(String[] args) {
        buildInPropertyAccessor();
        System.out.println("-------------------");
        customizedPropertyAccessor();
    }

    private static void customizedPropertyAccessor() {

        User user = new User("John", "Doe", true, "john.doe1@acme.com", 31);

        StandardEvaluationContext context = new StandardEvaluationContext(user);
        context.addPropertyAccessor(new MergeAccessor());

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("_merge");
        String _merge = expression.getValue(context, String.class);
        System.out.println(_merge);

        expression = parser.parseExpression("email");
        String email = expression.getValue(context, String.class);
        System.out.println(email);

        expression = parser.parseExpression("error");
        String error = expression.getValue(context, String.class);
        System.out.println(error);

    }


    private static void buildInPropertyAccessor() {
        User user1 = new User("John1", "Doe1", true, "john1.doe1@acme.com", 31);
        User user2 = new User("John2", "Doe2", true, "john2.doe2@acme.com", 32);

        Map<String, User> map = new HashMap<>();
        map.put("user1", user1);
        map.put("user2", user2);

        StandardEvaluationContext context = new StandardEvaluationContext(map);
        context.addPropertyAccessor(new MapAccessor());

        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("user1.email");

        String email = expression.getValue(context, String.class);
        System.out.println(email);
    }


    static class MergeAccessor implements PropertyAccessor {

        @Override
        public Class<?>[] getSpecificTargetClasses() {
            return new Class[]{User.class};
        }

        @Override
        public boolean canRead(EvaluationContext context, Object target, String name) throws AccessException {
            return (target instanceof User);
        }

        @Override
        public TypedValue read(EvaluationContext context, Object target, String name) throws AccessException {
            if ("_merge".equals(name)) {
                User user = (User) target;
                String merge = user.getFirstName() + ":" + user.getSecondName() + ":" + user.getEmail();
                return new TypedValue(merge);
            }
            Class<User> userClass = User.class;
            Field field;
            try {
                field = userClass.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException("no field : " + name);
            }

            field.setAccessible(true);
            Object result;
            try {
                result = field.get(target);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("cannot access field : " + name);
            }
            return new TypedValue(result);
        }

        @Override
        public boolean canWrite(EvaluationContext context, Object target, String name) throws AccessException {
            return false;
        }

        @Override
        public void write(EvaluationContext context, Object target, String name, Object newValue) throws AccessException {

        }
    }

}
