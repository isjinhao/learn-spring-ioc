package fsje.expression;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ISJINHAO
 * @Date 2020/11/28 14:39
 */
public class ExpressionTest {

    private static ExpressionParser parser = new SpelExpressionParser();

    public static void main(String[] args) {
        evaluateLiteralExpression();
        methodInvocationOnLiterals();
        accessingObjectProperties();
        operators();
        variables();
    }

    private static void evaluateLiteralExpression() {
        Expression exp = parser.parseExpression("'Hello World'");
        System.out.println(exp.getValue(String.class));

        exp = parser.parseExpression("6");
        System.out.println(exp.getValue(Integer.class));
    }


    private static void methodInvocationOnLiterals() {
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        System.out.println(exp.getValue(String.class));

        exp = parser.parseExpression("'Hello World'.length()");
        System.out.println(exp.getValue(Integer.class));

        exp = parser.parseExpression("'Hello World'.split(' ')");
        System.out.println(Arrays.deepToString(exp.getValue(String[].class)));
    }

    private static void accessingObjectProperties() {
        User user = new User("John", "Doe", true, "john.doe@acme.com", 30);
        Expression exp = parser.parseExpression("firstName");
        System.out.println(exp.getValue(user, String.class));

        exp = parser.parseExpression("getAdmin()==false");
        System.out.println(exp.getValue(user, Boolean.class));

        exp = parser.parseExpression("email.split('@')[0]");
        System.out.println(exp.getValue(user, String.class));

        exp = parser.parseExpression("age");
        System.out.println(exp.getValue(user, Integer.class));
    }

    private static void operators() {
        User user = new User("John", "Doe", true, "john.doe@acme.com", 30);
        Expression exp = parser.parseExpression("age > 18");
        System.out.println(exp.getValue(user, Boolean.class));

        exp = parser.parseExpression("age < 18 and getAdmin()");
        System.out.println((exp.getValue(user, Boolean.class)));
    }

    private static void variables() {
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

    private static class User {
        private String firstName;
        private String secondName;
        private String email;
        private Boolean isAdmin;
        private Integer age;

        public User(String firstName, String secondName, Boolean isAdmin, String email, Integer age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.isAdmin = isAdmin;
            this.email = email;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Boolean getAdmin() {
            return isAdmin;
        }

        public void setAdmin(Boolean admin) {
            isAdmin = admin;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
