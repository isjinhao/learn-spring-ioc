package ab.dependency.injection.generic;

import ab.dependency.injection.group.UserGroup1;
import sic.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.Field;

/**
 * @Author ISJINHAO
 * @Date 2020/12/15 16:30
 */
public class TestInstance {

    @Qualifier
    private User user1;

    @UserGroup1
    private User user2;

    public static void main(String[] args) throws Exception {

        TestInstance testInstance = new TestInstance();

        Field user1Field = TestInstance.class.getDeclaredField("user1");
        Field user2Field = TestInstance.class.getDeclaredField("user2");
        Qualifier user1FieldAnnotation = user1Field.getAnnotation(Qualifier.class);
        UserGroup1 user2FieldAnnotation = user2Field.getAnnotation(UserGroup1.class);
        System.out.println(user1FieldAnnotation.getClass().isInstance(user2FieldAnnotation.getClass()));
        System.out.println(user2FieldAnnotation.getClass().isInstance(user1FieldAnnotation.getClass()));


    }

}
