package expression;

import java.util.HashMap;
import java.util.Map;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author 01395265
 * @date 2020/12/31
 */
public class RootObjectDemo {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        User user = new User("John", "Doe", true, "john.doe@acme.com", 30);
        Map<String, Boolean> map = new HashMap<>();
        map.put("ahaha", true);
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user", user);
        context.setVariable("map", map);

        Expression exp = parser.parseExpression("#user.getAdmin() and #map.get('ahaha')");
        // 解析context里的数据
        System.out.println(exp.getValue(context, Boolean.class));

    }

}
